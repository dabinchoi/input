package my.examples.servlet;

import my.examples.dao.BoardDao;
import my.examples.dao.BoardDaoImpl;
import my.examples.dao.BoardDao;
import my.examples.dao.BoardDaoImpl;
import my.examples.dto.Board;
import my.examples.service.BoardService;
import my.examples.service.BoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 로그인한 관리자인가? 관리자일경우에만 실행.
        int seq = 0;
        try{
            String idStr = req.getParameter("id");
            seq = Integer.parseInt(idStr);
        }catch(Exception ex){
            // id가 잘못되었을 경우엔 에러페이지로 이동.
        }
       /* BoardDao boardDao = new BoardDaoImpl();
        boardDao.deleteBoard(seq);
*/

        BoardService boardService = new BoardServiceImpl();
        boardService.deleteBoard(seq);


        resp.sendRedirect("/list");
    }
}