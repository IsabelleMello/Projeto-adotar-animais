package br.ufpb.adocaoanimais;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


// Método para constructo da classe, que recebe o link
public class MensagemComLink extends JEditorPane {
    private static final long serialVersionUID = 1L;

    public MensagemComLink(String htmlBody) {
        super("text/html", "<html><body style=\"" + getStyle() + "\">" + htmlBody + "</body></html>");
        //Listener que monitora quando algum evento acontece com o link
        addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)) {
                    // Processa o evento click no link (por exemplo, com java.awt.Desktop.getDesktop (). Browse ())
                    System.out.println("Foi clicado");
                    try {
                    	//Abre o browsser
						Desktop.getDesktop().browse(e.getURL().toURI());
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}

                }
            }
        });
        setEditable(false);
        setBorder(null);
    }

    static StringBuffer getStyle() {
        // Para copiar estilo
    	// Cria uma Label para o link
        JLabel label = new JLabel();
        // Pega uma fonte
        Font fonte = label.getFont();
        // Define uma cor
        Color color = label.getBackground();

        // criação de um css a partir da fonte do rótulo
        // Cria a folha de estilo para os atributos
        StringBuffer style = new StringBuffer("font-family:" + fonte.getFamily() + ";");
        // Adiciona largura da fonte
        style.append("Espessura da fonte" + (fonte.isBold() ? "bold" : "normal") + ";");
        //Adiciona tamanho da fonte
        style.append("Tamanho da fonte:" + fonte.getSize() + "pt;");
        // Define cor de fundo
        style.append("Cor de fundo: rgb("+color.getRed()+","+color.getGreen()+","+color.getBlue()+");");
        return style;
    }
}