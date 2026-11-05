package Utils;

import com.raven.event.EventMenuSelected;
import Components.Menu_Item;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

//LISTA DE LAS CATEGORIAS EN EL MENU DE OPCIONES
public class List_Menu<E extends Object> extends JList<E> {
    
    private final DefaultListModel model;
    private int selectedIndex = -1;
    private int overIndex = -1;
    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
    }

    public List_Menu() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int index = locationToIndex(e.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof Model_Menu) {
                        Model_Menu menu = (Model_Menu) o;
                        if (menu.getTipo() == Model_Menu.TipoMenu.MENU) {
                            selectedIndex = index;
                            if (event != null) {
                                event.seleccionado(index);
                            }
                            
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                overIndex = -1; //Cuando el mouse no esta sobre alguna opcion, esta se mueve una capa hacia debajo
                repaint();//pinta de nuevo para quitar el efecto de seleccionado
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            
            @Override
            public void mouseMoved(MouseEvent e) {
                int index = locationToIndex(e.getPoint());//guarda la posicion del mouse
                if (index != overIndex) {
                    Object o = model.getElementAt(index);
                    if (o instanceof Model_Menu) {
                        Model_Menu menu = (Model_Menu) o;
                        if (menu.getTipo() == Model_Menu.TipoMenu.MENU) {
                            overIndex = index;
                        } else {
                            overIndex = -1;
                        }
                        repaint();
                    }
                }
            }
        });
    }
    
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean seleccionado, boolean enfocar) {
                Model_Menu data;
                if (o instanceof Model_Menu) {
                    data = (Model_Menu) o;
                } else {
                    data = new Model_Menu("", o + "", Model_Menu.TipoMenu.EMPTY);
                }
                Menu_Item item = new Menu_Item(data);
                item.setSeleccionado(selectedIndex == index);
                item.setOver(overIndex == index);
                return item;
            }
        };
    }
    
    public void addItem(Model_Menu data) {
        model.addElement(data);
    }
}
