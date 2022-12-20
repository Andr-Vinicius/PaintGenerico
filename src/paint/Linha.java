package paint;

import java.awt.Graphics2D;

/**
 *
 * @author vinicius
 */
public class Linha extends Forma{

    
    // Responsabilidade de desenho é da Classe e não do painel de componentes
    @Override
    public void desenhar(Graphics2D g2d){
        g2d = (Graphics2D) g2d.create(); // Não carregar modificações
        g2d.drawLine(xi, yi, xf, yf);
    }


}
