import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    // https://api.mocki.io/v2/549a5d8b/Top250Movies
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem
        // InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        // InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        BufferedImage imgOriginal = ImageIO.read(inputStream);
        
        // criar uma nova imagem em memória com transparência e tamanho novo
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);
        
        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        
        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 200, novaAltura - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("C:" + System.getProperty("file.separator")
 + "Users" + System.getProperty("file.separator") + "Daniele Fernanda" 
 + System.getProperty("file.separator") + "OneDrive" 
+ System.getProperty("file.separator") + "Rafael"
 + System.getProperty("file.separator") + "ImersaoJava" + System.getProperty("file.separator") + nomeArquivo));
    }
}