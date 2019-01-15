package my.examples.dto;

import java.util.Date;

public class Board {
    private int seq;
    private String user_id;
    private String user_name;
    private String title;
    private String content;
    private int pr_no;
    private int re_depth;
    private int re_ord;
    private Date reg_date;
    private int hit;
    private String del_yn;


  /*  public Board(int seq, String uesr_id, String user_name, String title, String content, int pr_no, int re_depth, int re_ord, Date reg_date, int hit, String del_yn) {
        this.seq = seq;
        this.uesr_id = uesr_id;
        this.user_name = user_name;
        this.title = title;
        this.content = content;
        this.pr_no = pr_no;
        this.re_depth = re_depth;
        this.re_ord = re_ord;
        this.reg_date = reg_date;
        this.hit = hit;
        this.del_yn = del_yn;
    }*/

public Board(String user_id,String user_name,String title,String content){
    this.user_id = user_id;
    this.user_name=user_name;
    this.title= title;
    this.content = content;

}



  public Board(int seq, String user_id, String title,String content,String user_name,Date reg_date,int hit){
      this.seq = seq;
      this.user_id = user_id;
      this.title = title;
      this.content = content;
      this.user_name = user_name;
      this.reg_date = reg_date;
      this.hit = hit;

  }

  public Board(int seq,String user_name,String title, String content, Date reg_date, int hit){
    this.seq = seq;
    this.user_name = user_name;
    this.title = title;
    this.content = content;
    this.reg_date = reg_date;
    this.hit = hit;
  }




    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getUesr_id() {
        return user_id;
    }

    public void setUesr_id(String uesr_id) {
        this. user_id = uesr_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPr_no() {
        return pr_no;
    }

    public void setPr_no(int pr_no) {
        this.pr_no = pr_no;
    }

    public int getRe_depth() {
        return re_depth;
    }

    public void setRe_depth(int re_depth) {
        this.re_depth = re_depth;
    }

    public int getRe_ord() {
        return re_ord;
    }

    public void setRe_ord(int re_ord) {
        this.re_ord = re_ord;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getDel_yn() {
        return del_yn;
    }

    public void setDel_yn(String del_yn) {
        this.del_yn = del_yn;
    }

    @Override
    public String toString() {
        return "Board{" +
                "seq=" + seq +
                ", uesr_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pr_no=" + pr_no +
                ", re_depth=" + re_depth +
                ", re_ord=" + re_ord +
                ", reg_date=" + reg_date +
                ", hit=" + hit +
                ", del_yn='" + del_yn + '\'' +
                '}';
    }
}
