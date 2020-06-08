import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;




public class Filter {

	private JFrame frame;
	private JTextField M3;
	private JTextField M1;
	private JTextField M2;
	private JTextField M4;
	private JTextField M5;
	private JTextField M6;
	private JTextField M7;
	private JTextField M8;
	private JTextField M9;
	private JLabel input_image;
	private JLabel output_image;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filter window = new Filter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Filter() {
		initialize();
		ImageIcon inputIMG=new ImageIcon(getClass().getResource("/image.png"));
		input_image.setIcon(inputIMG);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 440, 230);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Run");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				BufferedImage Image =null;		 

				try {
					
					int[] matrix = new int[9];
					matrix[0]=Integer.parseInt(M1.getText());
					matrix[1]=Integer.parseInt(M2.getText());
					matrix[2]=Integer.parseInt(M3.getText());
					matrix[3]=Integer.parseInt(M4.getText());
					matrix[4]=Integer.parseInt(M5.getText());
					matrix[5]=Integer.parseInt(M6.getText());
					matrix[6]=Integer.parseInt(M7.getText());
					matrix[7]=Integer.parseInt(M8.getText());
					matrix[8]=Integer.parseInt(M9.getText());
					Image=ImageIO.read(getClass().getResource("/image.png"));	
					BufferedImage returnImage=new BufferedImage(Image.getWidth(),Image.getHeight(),BufferedImage.TYPE_INT_ARGB);
					for (int i=1;i<Image.getWidth()-1;i++) {
						for (int j=1;j<Image.getHeight()-1;j++) {
							int R=0;
							int G=0;
							int B=0;
							int index=0;
							int Plus=0;
					      for(int x=-1;x<=1;x++) {
					    	  for(int y=-1;y<=1;y++) {
						    	  R=(new Color(Image.getRGB(i+y,j+x))).getRed()*matrix[index]+R;
						    	  G=(new Color(Image.getRGB(i+y,j+x))).getGreen()*matrix[index]+G;
						    	  B=(new Color(Image.getRGB(i+y,j+x))).getBlue()*matrix[index]+B;
						    	  Plus=matrix[index]+Plus;
						    	  index++;
						     
					    	  }
					    	  
					      }
							

				R=R/Plus;
				G=G/Plus;
				B=B/Plus;
				int A=new Color(Image.getRGB(i,j)).getAlpha();
							

							
				Color gcolor= new Color(R,G,B,A);			
				returnImage.setRGB(i, j, gcolor.getRGB());
						}
						
						
					}
					
				//	ImageIO.write(GaussianImage,"png",new File("C:\\Users\\TUNCAY\\Desktop\\Java_Denemeleri\\image9.png"));
					ImageIcon outputIMG=new ImageIcon(returnImage);
					output_image.setIcon(outputIMG);
				}catch(IOException e1) {
					
					
				}



				
				
				
				
				
			}
		});
		btnNewButton.setBounds(10, 115, 80, 45);
		frame.getContentPane().add(btnNewButton);
		
		M3 = new JTextField();
		M3.setText("1");
		M3.setBounds(70, 22, 20, 20);
		frame.getContentPane().add(M3);
		M3.setColumns(10);
		
		M1 = new JTextField();
		M1.setText("1");
		M1.setColumns(10);
		M1.setBounds(10, 22, 20, 20);
		frame.getContentPane().add(M1);
		
		M2 = new JTextField();
		M2.setText("1");
		M2.setColumns(10);
		M2.setBounds(40, 22, 20, 20);
		frame.getContentPane().add(M2);
		
		M4 = new JTextField();
		M4.setText("1");
		M4.setColumns(10);
		M4.setBounds(10, 53, 20, 20);
		frame.getContentPane().add(M4);
		
		M5 = new JTextField();
		M5.setText("1");
		M5.setColumns(10);
		M5.setBounds(40, 53, 20, 20);
		frame.getContentPane().add(M5);
		
		M6 = new JTextField();
		M6.setText("1");
		M6.setColumns(10);
		M6.setBounds(70, 53, 20, 20);
		frame.getContentPane().add(M6);
		
		M7 = new JTextField();
		M7.setText("1");
		M7.setColumns(10);
		M7.setBounds(10, 84, 20, 20);
		frame.getContentPane().add(M7);
		
		M8 = new JTextField();
		M8.setText("1");
		M8.setColumns(10);
		M8.setBounds(40, 84, 20, 20);
		frame.getContentPane().add(M8);
		
		M9 = new JTextField();
		M9.setText("1");
		M9.setColumns(10);
		M9.setBounds(70, 84, 20, 20);
		frame.getContentPane().add(M9);
		
		input_image = new JLabel("------------INPUT------------");
		input_image.setFont(new Font("Arial", Font.PLAIN, 11));
		input_image.setBackground(Color.WHITE);
		input_image.setBounds(121, 22, 128, 128);
		frame.getContentPane().add(input_image);
		
		output_image = new JLabel("------------OUTPUT----------");
		output_image.setFont(new Font("Arial", Font.PLAIN, 11));
		output_image.setBounds(282, 22, 128, 128);
		frame.getContentPane().add(output_image);
	}
}
