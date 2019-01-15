package my.examples.servlet;

import my.examples.dao.BoardDao;
import my.examples.dao.BoardDaoImpl;
import my.examples.dto.Board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// read?id=5
@WebServlet(name = "ReadServlet", urlPatterns = "/read")
public class ReadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("seq");
        int seq = 0;
        try{
            seq = Integer.parseInt(idStr);
        }catch(Exception ex){
            // 오류 화면으로 redirect
            return;
        }
        BoardDao boardDao = new BoardDaoImpl();
        Board board = boardDao.getBoard(seq);
        if(board == null){
            // 오류 화면으로 redirect
            return;
        }

        boardDao.updateReadCount(seq);

        req.setAttribute("board", board);

        System.out.println(board.toString());
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/view.jsp");
        requestDispatcher.forward(req, resp);
    }
}

