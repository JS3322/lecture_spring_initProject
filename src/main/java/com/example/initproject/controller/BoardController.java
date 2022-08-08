package com.example.initproject.controller;

//외장 라이브러리 호출(import), gradle로 설치한 라이브러리
import com.example.initproject.controller.board.GetBoard;
import com.example.initproject.domain.Board;
//import com.example.initproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//내장 라이브러리 호출 (import)
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Controller
public class BoardController {

//    @Autowired
//    private BoardService boardService;

    //CRUD 정리
    //중복 코드 정리

    //step3. 사용자 생성 객체 사용
    static ArrayList<Board> board_array = new ArrayList<Board>();
    static int count = 0;

    //@GetMapping 또는 @PostMapping은 @RequestMapping의 자식 클래이다
    //@RequestMapping의 기능을 모두 쓸 수 있다
    //자식클래스 어노테이션이 아닌 부모클래스 어노테이션을 쓰는 이유는 기능의 한정을 통해서
    //서버의 리소스 감소 및 보안을 위해서 이다

    /**
     * Board domain CONTROLLER
     * @Param NULL
     * @return String HTML파일과 연결 (ViewResolver)
     * @author 김준석
     * @version 20220808.0.0.1
     * */
    @GetMapping("insertBoard")
    public String insertBoard() {
        System.out.println("----------insertBoard 실행----------");
        return "insertBoard";
    }

    //[클라이언트]html form태그의 method속성의 값인 post를 인식하여 아래의 @PostMapping에 연결
    /**
     * Board domain CONTROLLER
     * @Param String HTML에서 받아온 데이터
     * @return String HTML파일과 연결 (ViewResolber)
     * @author 김준석
     * @version 20220808.0.0.1
     * */
    @PostMapping("insertBoard")
    public String insertBoard(
            @RequestParam("title")String title,
            @RequestParam("writer")String writer,
            @RequestParam("content")String content
            ) {
        System.out.println("----------insertBoard 실행----------");
        count++;
//        Board board = new Board();
//
//        board.setSeq((long) count);
//        board.setTitle(title);
//        board.setWriter(writer);
//        board.setContent(content);
//        board.setCreateDate(new Date());
//        board.setCnt(0L);
//        board_array.add(board);

        return "redirect:getBoardList";
    }


    //@어노테이션은 메서드 혹은 클래스에 속성, 정의를 해서 스프링이나 자바에서 찾기 쉽도록 해주는 선언부
    //예) @Override 은 부모 메서드를 재정의하여 사용한다고 자바나 스프링에게 속성 명시
    //@RequestParam : [클라이언트]에서 string문자열을 [서버]에 전달하는 매개변수 선언
    //@RequestParam("title")String title에서 ("title")은 [클라이언트]의 name이라는 속성로써
    //key값을 매개변수를 전달

    /**
     * Board domain CONTROLLER
     * @Param String HTML에서 받아온 데이터
     * @return String HTML파일과 연결 (ViewResolber)
     * @author 김준석
     * @version 20220808.0.0.1
     * */
    @RequestMapping("getBoard")
    public String getBoard(
            @RequestParam HashMap<String,String> boardMap,
//            @RequestAttribute Board board1,
//            @RequestBody Board board2,
            @RequestParam("seq")String seq,
            Model model) {

        // @PathVariable 파라미터 활용
        // @RequestBody는 MessageConverter를 통해 Json 형태의 HTTP Body를 Java 객체로 변환
        // @ModelAttribute는 multipart/form-data 형태의 HTTP Body 및 파라미터들을 객체에 바인딩

        System.out.println(boardMap.get("title"));
        System.out.println(boardMap.get("writer"));
//        System.out.println(board2.getTitle());
        System.out.println("----------getBoard 실행----------");
        //seq를 조회하여 리턴해주는 메서드 생성
        model.addAttribute("board", GetBoard.getBoard(seq, board_array, model));
        System.out.println(model.getAttribute("title"));
        return "getBoard";
    }

    //@RequestMapping은 [서버]에서 디스페처서블릿을 통해 [클라이언트]html의 action태그의 주소와 동일한
    //문자열을 찾는 매핑기능(연결)이 실행되고 하단에 메서드가 실행
    //return String인 이유는 뷰리졸버가 html파일을 찾기 위한 문자열을 리턴

    @GetMapping("/getBoardList")
    public String getBoardList(Model model, Board board) {

//        List<Board> boardList = boardService.getBoardList(board);

        model.addAttribute("boardList", board_array);

        return "getBoardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(@RequestParam("seq")String seq) {

        for(int i=0; i<board_array.size(); i++) {
            if(Long.toString(board_array.get(i).getSeq()).equals(seq)) {
                board_array.remove(i);
            }
        }

        return "redirect:getBoardList";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(
            //HTML에서 name속성을 가진 값을 매개변수 String seq에 할당 = @RequestParam("seq")
            @RequestParam("seq")String seq,
            @RequestParam("title")String title,
            @RequestParam("content")String content
    ) {
        System.out.println("update board access");
        //board_array배열을 순회하여 board객체의 seq필드값을 매개변수 seq와 비교하여 true값 찾기
        for(int i=0; i<board_array.size(); i++) {
            if (Long.toString(board_array.get(i).getSeq()).equals(seq)) {
                //setTile과 같은 setter로 데이터 변경
                board_array.get(i).setTitle(title);
                board_array.get(i).setContent(content);
            }
        }
        return "redirect:getBoardList";
    }
}
