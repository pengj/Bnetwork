import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.UIManager;

public class PopupWindowTest {
	private static final long serialVersionUID = 1L;
	private static final Integer STARTING_POS_X = 300;
	private static final Integer STARTING_POS_Y = 300;

	public void showMessage(String text) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		Toolkit t = Toolkit.getDefaultToolkit();
		JTextArea area = new JTextArea(7, 30);
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		final JWindow window = new JWindow();

		final JButton ok = new JButton("Reply");
		ok.setSize(40, 20);

		final JButton close = new JButton("Close");
		close.setSize(20, 20);

		ActionListener listener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == ok){
					JOptionPane.showMessageDialog(null, "Just a sample message.");
				} else if (e.getSource() == close){
					window.dispose();
				}
			}

		};

			ok.addActionListener(listener);
			close.addActionListener(listener);

			area.setEditable(false);
			area.setOpaque(true);
			area.setAutoscrolls(true);
			area.setText(text);
			area.setBackground(new Color(202,219,243));

			JScrollPane spane = new JScrollPane(area,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			spane.setBorder(BorderFactory.createEtchedBorder());

			panel.setBackground(new Color(203,222,148));
			panel.add(spane);
			panel.add(ok);
			panel.add(close);

			frame.getContentPane().add(panel);
			frame.pack();

			window.setLocation((int) (t.getScreenSize().getWidth() - STARTING_POS_X),
					(int) (t.getScreenSize().getWidth() - STARTING_POS_Y));
			window.setContentPane(frame.getContentPane());
			window.setBounds(0, 0, 265, 168);
			window.setAlwaysOnTop(true);
			
			/*window.setVisible(true);*/

			for (int i = 900; i > 300; i = i - 50) {
				window.setLocation(
						(int) (t.getScreenSize().getWidth() - STARTING_POS_X),
						(int) (t.getScreenSize().getHeight() -i));
				window.setVisible(true);
			}
	}

	public static void main(String[] args) throws Exception {
		new PopupWindowTest().showMessage("The message goes here");
	}
}