//package padroesdeprojeto.Strategy;
//
//import com.sun.javafx.binding.StringFormatter;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.io.Writer;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class TxtArquivoStrategy implements ArquivoStrategy {
//
//    @Override
//    public void gerarArquivo(ArrayList<Produto> prods, String caminhoArquivo) {
//        try {
//            OutputStream outputStream = new FileOutputStream(caminhoArquivo);
//            Writer out = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
//            String format = "Produto: %04d - Nome: %-20s  Preco: R$ %.2f \n";
//            for(Produto p: prods)
//                out.write(String.format(format, p.getId(), p.getNome(), p.getPreco()));
//            out.close();
//        }
//        catch(FileNotFoundException e) {
//            System.err.printf(e.getMessage());
//        } catch (IOException e) {
//            System.err.printf(e.getMessage());
//        }
//    }
//
//}
