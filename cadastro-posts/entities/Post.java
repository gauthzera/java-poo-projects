package entities;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
   private LocalDateTime moment;
   private String title;
   private String content;
   private Integer likes;

   private List<Comment> comments=new ArrayList<>();

   private static final DateTimeFormatter fmt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");   //formato para exibição da data

   public Post(){}

    public Post(LocalDateTime moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public void imprimeComent(){
       if(comments.isEmpty()){      //se não tiver nenhum comentário no post
           System.out.println("Nenhum comentário no post");
           return;
       }
        for(Comment x: comments){
            System.out.println(x);
        }
    }

    public void addComent(String comment){
       if(comment==null)return;
       comments.add(new Comment(comment));
    }

    public String toString(){
        return String.format("%s\n%d likes - %s\n%s",title,likes,moment.format(fmt),content);
    }


}