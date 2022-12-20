package paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author vinicius
 */
public class PainelDesenho extends JPanel{
    
    private TipoDesenho tipo;
    
    private List<Forma> formas;
    private Forma formaTemp;
    
    private int xPress;
    private int yPress;
    
    public PainelDesenho(){
        // Ouvintes de Mouse
        
        tipo = TipoDesenho.LINHA;
        formas = new ArrayList<>();
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                // Quando o mouse for pressionado
                //System.out.printf("Pressionou: (%d, %d)\n", e.getX(), e.getY());
                xPress = e.getX();
                yPress = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Quando o mouse for solto
                //System.out.printf("Soltou: (%d, %d)\n", e.getX(), e.getY());
                
                Forma novaForma = null;
                
                switch(tipo){
                    case LINHA:
                        novaForma = new Linha();
                        break;
                    case RETANGULO:
                        novaForma = new Retangulo();
                        break;
                    case ELIPSE:
                        novaForma = new Elipse();
                        break;
                }
                
                if(novaForma != null){
                    novaForma.setXi(xPress);
                    novaForma.setYi(yPress);
                    novaForma.setXf(e.getX());
                    novaForma.setYf(e.getY());
                    formas.add(novaForma);


                    formaTemp = null;
                    // Método que reforça o desenho do componente
                    repaint();                    
                }
                

            }
            
            
            
        });
        
        addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                // Enquanto arrastar o Mouse pressionado
                //System.out.printf("Arrastando: (%d, %d)\n", e.getX(), e.getY());
                
                switch(tipo){
                    case LINHA:
                        formaTemp = new Linha();
                        break;
                    case RETANGULO:
                        formaTemp = new Retangulo();
                        break;
                    case ELIPSE:
                        formaTemp = new Elipse();
                        break;                   
                }
                
                formaTemp.setXi(xPress);
                formaTemp.setYi(yPress);
                formaTemp.setXf(e.getX());
                formaTemp.setYf(e.getY());
                // Método que reforça o desenho do componente
                repaint();
            }
            
        });
    }

    // Anotação pra barrar sobrescrever método de maneira incorreta
    @Override
    protected void paintComponent(Graphics g) {
        // Graphics é o contexto gráfico, funcionalidades para desenhar
        // Tem que manter o super pra garantir que todos os componentes 
        //desenhados corretamente
        
        super.paintComponent(g); 
        
        // create() - Cópia do contexto gráfico atual e faz o casting para o 2D
        Graphics2D g2d = (Graphics2D) g.create();
        // Suavização das linhas
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        
        // Desenhar linha (x e y iniciais, x e y finais)
        // Questão legada (?), eixo y é invertido -> x cresce pra direita e o
        // y cresce pra baixo, além disso o (0, 0) começa no canto superior direito
        
        // Variável: Estrutura
        for(Forma forma: formas){
            forma.desenhar(g2d);
        }
        
        
        if(formaTemp != null){
            formaTemp.desenhar(g2d);
            
        }
        
        
    }

    public void setTipo(TipoDesenho tipo) {
        this.tipo = tipo;
    }
   
    
    
}
