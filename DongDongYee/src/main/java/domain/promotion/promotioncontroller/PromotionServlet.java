package domain.promotion.promotioncontroller;

import domain.comment.Comment;
import domain.comment.CommentService;
import domain.promotion.Promotion;
import domain.promotion.PromotionService;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/promotion")
public class PromotionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PromotionService promotionService = new PromotionService();
    private final CommentService commentService = new CommentService();

    public PromotionServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
//        세션 검사
        HttpSession session = request.getSession();
        if (session.getAttribute("userID") == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("<script>alert('세션이 만료되었습니다. 다시 로그인 해주세요.'); window.location.href='Login.jsp';</script>");
            return;
        }
        Long promotionID = Long.parseLong(request.getParameter("id"));
        Promotion promotion = promotionService.read(promotionID);
        List<Comment> commentList = commentService.read(promotionID);
        request.setAttribute("promotionItem", promotion);
        request.setAttribute("commentList", commentList);
        request.getRequestDispatcher("PromotionItem.jsp?id=" + promotion.getPromotionID()).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
//        세션 검사
        HttpSession session = request.getSession();
        if (session.getAttribute("userID") == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("<script>alert('세션이 만료되었습니다. 다시 로그인 해주세요.'); window.location.href='Login.jsp';</script>");
            return;
        }
        Promotion promotion = new Promotion();
        promotion.setUserID(request.getParameter("userID"));
        promotion.setPromotionName(request.getParameter("promotionName"));
        promotion.setPromotionContents(request.getParameter("promotionContents"));
        promotion.setPromotionClub(request.getParameter("promotionClub"));
        promotion = promotionService.publish(promotion);
        response.sendRedirect("promotion?id=" + promotion.getPromotionID().toString());
    }
}