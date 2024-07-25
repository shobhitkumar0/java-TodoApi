package com.example.todoSpring.demo;

public class Todo {


    /**
     * userId : 1
     * id : 1
     * title : delectus aut autem
     * completed : false
     */

    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todo (int id,boolean completed,String title,int userId){
        this.id=id;
        this.title=title;
        this.completed=completed;
        this.title=title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString(){
        return
             "Todo{"+
             "id = '" + id +'\''+
             ",completed = '" + completed +'\''+
             ",title = '"  + title +'\'' +
             ",userId= '" + userId +'\''+
             "}";
    }
}
