import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.*;

import java.time.LocalDateTime;

public class Main{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);

        System.out.print("Quantidade de posts para cadastrar: ");
        int n=sc.nextInt();
        sc.nextLine();

        List<Post> posts=new ArrayList<>(); //lista dos posts

        String title,content,comment;
        int likes,qcomment;

        System.out.println("Cadastro de posts: ");
        for(int i=0;i<n;i++){
            System.out.printf("Post %d:\n",i+1);
            System.out.print("Título do post: ");
            title=sc.nextLine().trim();

            System.out.print("Conteúdo: ");
            content=sc.nextLine().trim();

            System.out.print("Quantos likes: ");
            likes=sc.nextInt();

            System.out.print("Quantidade de comentários: ");
            qcomment=sc.nextInt();
            sc.nextLine();

            Post p=new Post(LocalDateTime.now(),title,content,likes); //criação do post

                for(int j=0;j<qcomment;j++){
                    System.out.printf("Comentário %d: ",j+1);
                    comment=sc.nextLine().trim();
                    p.addComent(comment);       //adição dos comentários
                }
                posts.add(p);

            System.out.println();
        }

        System.out.println("Posts cadastrados: ");  //exibição
        for(Post x : posts){
            System.out.println(x);
            System.out.println("Comentários:");
            x.imprimeComent();
            System.out.println();
        }

        sc.close();
    }
}