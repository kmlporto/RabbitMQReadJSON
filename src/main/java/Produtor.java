import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.tools.json.JSONWriter;
import java.util.ArrayList;
import java.util.List;


public class Produtor {
    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);

        String NOME_FILA = "filaJson";

        List<Livro> livros = new ArrayList<>();
        for (int i=0; i<11; i++) {
            Livro livro = new Livro("Livro"+i, "Letras");
            livros.add(livro);
        }

        JSONWriter jsonWriter = new JSONWriter();
        try(
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel()) {
            channel.queueDeclare(NOME_FILA, false, false, false, null);
            String mensagem = jsonWriter.write(livros);
            channel.basicPublish("", NOME_FILA, null, mensagem.getBytes());
            System.out.println("Enviei mensagem: " + mensagem);
        }
    }
}
