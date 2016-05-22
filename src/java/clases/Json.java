/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;



import java.util.List;
import javax.ejb.EJB;
import clases.Json;
import clases.Nba;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 *
 * @author usuario
 */
public class Json {
      
 
      String nombre,rebotes,edad,puntos,linea;
      String nombre1,rebotes1,edad1,puntos1;
      String nombre2,rebotes2,edad2,puntos2;
      public void quitarComa(){
       
       nombre1=nombre.substring(0, nombre.length()-1);
        rebotes1=rebotes.substring(0, rebotes.length()-1);
         puntos1=puntos.substring(0, puntos.length()-1);
            edad1=edad.substring(0, edad.length()-1);
         
   }
   public void annadirCaracter(){
       nombre2=nombre1+"],";
            rebotes2=rebotes1+"],";
            puntos2=puntos1+"],";
            edad2=edad1+"]";
       
   }
    
    public String Json() throws HibernateException{
                
          
   
        List<Nba> l;
       Nba prueba=new Nba();
        l=prueba.obtenListaContactos();
    nombre="\"nombre\":[";
       rebotes="\"rebotes\":[";
       puntos="\"puntos\":[";
        edad="\"edad\":[";
         for (int i=0;i<l.size();i++){
           
           nombre+="\""+l.get(i).getNombre()+"\","; 
           rebotes+="\""+l.get(i).getRebotes()+"\","; 
           puntos+="\""+l.get(i).getPuntos()+"\",";  
       edad+="\""+l.get(i).getEdad()+"\","; 
                   }
      quitarComa();
       annadirCaracter();
       
            linea="{"+nombre2+"\r\n"+rebotes2+"\r\n"+puntos2+"\r\n"+edad2+"}";
       
       
       System.out.println("el json es"+linea);
       return linea;
    }
}
