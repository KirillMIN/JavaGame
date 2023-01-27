import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

import static java.lang.Math.random;

public class Display {
    static String secretName;

    static JPanel  jPanel = new JPanel();

    static JPanel textPanel = new JPanel(new FlowLayout());

     static Image image;


    public static void main(String[] args) {
        //Создание фрейма
        JFrame frame = new JFrame("JavaGame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Размещение фрейма
        Toolkit  toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 450, dimension.height / 2 - 300, 1000, 750);



        //Создание текстового окна
        JTextField bigField = new JTextField("Введите имя файла(хрю-хрю) ", 20);
        bigField.setBorder(BorderFactory.createLineBorder(Color.black));
        textPanel.setBorder(BorderFactory.createTitledBorder("PigGame"));
        bigField.setEnabled(false);
        textPanel.add(bigField);

        //Создание текстогого поля для правил
        TextArea textArea = new TextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        textArea.append("Нажми на свинью, чтобы начать игру. " +
                "Найди файл и введи его имя в тектсовое поле");
        textArea.setVisible(false);



        //создание окна ввода
        JButton OkButton = new JButton("ok");

        textPanel.add(OkButton);

        //создание окна правил
        JButton rulesButton = new JButton("rules");
        rulesButton.setToolTipText("Нажми на свинью и найди секретный файл");

        textPanel.add(rulesButton);
        textPanel.add(textArea);


        // Настройка шрифта
        bigField.setFont(new Font("Dialog", Font.PLAIN, 14));
        bigField.setHorizontalAlignment(JTextField.LEFT);


        //Добавление свиньи
        image = new ImageIcon( "src/main/resources/pig/свинка2.png").getImage();
        JLabel label = new JLabel(new ImageIcon(image)){
            public void paint(Graphics g){
                g.drawImage(image, 0, 0, 950, 600, null);
            }
        };
        jPanel.add(label);


        OkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = bigField.getText();
                System.out.println(text);
                System.out.println(secretName);
                if(secretName.equals(text)){
                    System.exit(0);
                }
                else{
                    image = new ImageIcon( "src/main/resources/pig/свинка5.png").getImage();
                    label.repaint();
                }
            }
        });

        //Создание обеда для свиньи
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                image = new ImageIcon( "src/main/resources/pig/свинка3.png").getImage();
                label.repaint();
                bigField.setEnabled(true);
                textPanel.repaint();

                //Создание имени файла
                StringBuilder fileName = new StringBuilder();
                int randomBound = new Random().nextInt(10);
                for (int i = 0; i < randomBound; i++) {
                    fileName.append(RandomStringUtils.randomAlphabetic(10));
                }
                Display.secretName = String.valueOf(fileName);

                //Создание пути файла
                ArrayList<File> dirs = FileSaver.chkDir();
                int randomPath = new Random().nextInt(dirs.size());
                String path = String.valueOf(dirs.get(randomPath));
                File file = null;
                    file = new File(path , String.valueOf(fileName));
                try {
                    boolean fileFlag = file.createNewFile();
                    System.out.println(fileFlag);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println(file.getAbsolutePath());


            }
        });

        //Добавление элементов
        frame.add(jPanel, BorderLayout.SOUTH);
        frame.add(textPanel, BorderLayout.NORTH);
        frame.setVisible(true);


    }

}
