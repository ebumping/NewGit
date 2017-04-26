package synth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SynthUI extends Synth1{
	//Synth1 syn = new Synth1();

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SynthUI window = new SynthUI();
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
	public SynthUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Synthesizer synth = null;
				try {
					synth = MidiSystem.getSynthesizer();
					synth.open();
					MidiChannel[] mc = synth.getChannels();
					Instrument[] inst = synth.getDefaultSoundbank().getInstruments();
					synth.loadInstrument(inst[2]);
					//final MidiChannel[] mc = synth.getChannels();
					mc[1].noteOn(60, 300);
					System.out.println(inst);
					System.out.println(mc);
				} catch (MidiUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(button);
	}
}
