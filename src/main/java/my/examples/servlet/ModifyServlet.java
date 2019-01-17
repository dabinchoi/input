package my.examples.servlet;

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


@WebServlet(name = "ModifyServlet", urlPatterns = "/modify")
public class ModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter("seq");

        int seq = 0;

        try {
            seq = Integer.parseInt(idStr);
        } catch (Exception ex) {
            return;
        }
        BoardDao boardDao = new BoardDaoImpl();
        Board board = boardDao.getBoard(seq);




        if (board == null) {
            // 오류 화면으로 redirect
            return;
        }

        req.setAttribute("seq,",seq);
        req.setAttribute("board", board);


        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/modify.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

      //  String title = req.getParameter("title");
     //   String content = req.getParameter("content");


        Integer seq = 0;
       String title = null;
       String content=null;

        try {
            String idStr = req.getParameter("seq");

            title = req.getParameter("title");
            content = req.getParameter("content");




          /*  seq = Integer.parseInt(idStr);*/
         /*   BoardService boardService = new BoardServiceImpl();*/

            seq = Integer.parseInt(idStr);

        } catch (Exception ex) {
            // id가 잘못되었을 경우엔 에러페이지로 이동.
        }
        BoardDao boardDao = new BoardDaoImpl();
        boardDao.deleteBoard(seq);

        resp.sendRedirect("/list");
    }
}

