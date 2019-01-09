package my.examples.input;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BoardListServlet", urlPatterns = "/board/list")
public class BoardListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

     //   req.setAttribute("count", 100);
        List<Board> list = new ArrayList<>();
      //  list.add(new Board("kim", "title1", "content1"));
        list.add(new Board("1","할수있을까? 할수있을거야.. 될꺼야....", "최다빈" ,"ㅎㅇㅎㅇ"));
        list.add(new Board("2","아니 왜안되 아오 왜 이레 아 슈발 ㅡㅡㅡ아오 ㅡ,ㅡㅡㅡ", "빵영규" ,"ㅁㅇㄴㄻㅇㄴㄹ"));
        list.add(new Board("3","오됬어 오오오오오 오~!~~~!", "최성헌" ,"ㅁㅇㄴㄻㅇㄴㄹ"));
        req.setAttribute("list", list);





        RequestDispatcher requestDispatcher
                = req.getRequestDispatcher("/WEB-INF/views/list2.jsp");
        requestDispatcher.forward(req, resp);
    }
}