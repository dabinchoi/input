package my.examples.input;

import java.time.LocalDateTime;

public class Board {
    private String number; //넘버



    private String title; // 제목
    private String name;  //이름
    private LocalDateTime regdate;  //날짜
    private String content;   //내용
    private String password;   //비밀번호


    public Board() {
        regdate = LocalDateTime.now();  //현재 시간을 저장.
    }

    public Board(String number,String title,String name,String content){
        this();
        this.number = number;
        this.title = title;
        this.name = name;

        this.content =content;


    }


    public Board(String number,String name, String password, String title, String content){
       this(number, name, title, content);
       this.password = password;
    }



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDateTime regdate) {
        this.regdate = regdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

/* private Long id;
    private String name;
    private String password;
    private String title;
    private String content;
    private LocalDateTime regdate;

    public Board() {
        regdate = LocalDateTime.now();  //현재 시간을 저장.
    }

    public Board(String name, String title, String content) {
        this();
        this.name = name;
        this.title = title;
        this.content = content;

    }
    public Board(String name, String password, String title,String content){
        this(name,title,content);
        this.password = password;
    }

    //getter,setter메소드
    //id프로퍼티

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDateTime getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDateTime regdate) {
        this.regdate = regdate;
    }*/
}
