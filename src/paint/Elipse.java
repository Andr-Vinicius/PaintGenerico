package paint;

import java.awt.Graphics2D;

/**
 *
 * @author vinicius
 */
public class Elipse extends Forma{
    
    // Responsabilidade de desenho é da Classe e não do painel de componentes
    @Override
    public void desenhar(Graphics2D g2d){
        g2d = (Graphics2D) g2d.create();
        
        int xdi = xi <= xf ? xi : xf;
        int ydi = yi <= yf ? yi : yf;
        int xdf = xi <= xf ? xf : xi;
        int ydf = yi <= yf ? yf : yi;
        
        g2d.drawOval(xdi, ydi, xdf-xdi, ydf-ydi);
    }

}
