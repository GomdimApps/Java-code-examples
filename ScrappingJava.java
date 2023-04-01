// 1 - Exemplo //
import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;  
import java.io.IOException;  
  
public class ScrapingExample {  
   public static void main(String[] args) {  
      Document doc;  
      try {  
         doc = Jsoup.connect("http://example.com/").get();  
         Elements links = doc.select("a[href]");  
         for (Element link : links) {  
            System.out.println("\nlink : " + link.attr("href"));  
            System.out.println("text : " + link.text());  
         }  
      } catch (IOException e) {  
         e.printStackTrace();  
      }  
   }  
}

// 2 - Exemplo //
O código abaixo procura por todos os links dentro da página principal da Pobreflix usando a biblioteca Java JSoup.

// Importação da biblioteca JSoup
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// URL para extrair os links da página
String URL = "https://pobreflix.biz/";

// Cria um documento da página
Document document = Jsoup.connect(URL).get();

// Obtém todos os links da página
Elements links = document.select("a[href]");

// Para cada link, imprime a URL
for (Element link : links){
    System.out.println(link.attr("abs:href"));
}

// 3 - Exemplo //


// 4 - Exemplo //
// 4 - Exemplo //
// 5 - Exemplo //