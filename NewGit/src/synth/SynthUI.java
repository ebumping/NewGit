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
import java.awt.Color;
import javax.sound.midi.Soundbank;;

public class SynthUI extends Synth1{
	//Synth1 syn = new Synth1();

	private JFrame frame;
	int r = 60;
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
		frame.setBounds(100, 100, 540, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Synthesizer synth = null;
				try {
					synth = MidiSystem.getSynthesizer();
					MidiChannel[] mc = synth.getChannels();
					Instrument[] inst = synth.getDefaultSoundbank().getInstruments();
					synth.loadInstrument(inst[50]);
					synth.open();
					//final MidiChannel[] mc = synth.getChannels();
					mc[2].noteOn(r, 300);
					System.out.println(synth.getLoadedInstruments());
				} catch (MidiUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button.setBounds(10, 227, 74, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Synthesizer synth = null;
				try {
					synth = MidiSystem.getSynthesizer();
					MidiChannel[] mc = synth.getChannels();
					Instrument[] inst = synth.getDefaultSoundbank().getInstruments();
					synth.loadInstrument(inst[3]);
					synth.open();
					//final MidiChannel[] mc = synth.getChannels();
					mc[2].noteOn(r+2, 300);
					System.out.println(synth.getLoadedInstruments());
				} catch (MidiUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(94, 227, 67, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.setForeground(Color.BLACK);
		button_2.setBackground(Color.BLACK);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Synthesizer synth = null;
				try {
					synth = MidiSystem.getSynthesizer();
					MidiChannel[] mc = synth.getChannels();
					Instrument[] inst = synth.getDefaultSoundbank().getInstruments();
					synth.loadInstrument(inst[3]);
					synth.open();
					//final MidiChannel[] mc = synth.getChannels();
					mc[2].noteOn(r+3, 300);
					System.out.println(synth.getLoadedInstruments());
				} catch (MidiUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(122, 193, 79, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Synthesizer synth = null;
				try {
					synth = MidiSystem.getSynthesizer();
					MidiChannel[] mc = synth.getChannels();
					Instrument[] inst = synth.getDefaultSoundbank().getInstruments();
					synth.loadInstrument(inst[3]);
					synth.open();
					//final MidiChannel[] mc = synth.getChannels();
					mc[2].noteOn(r+5, 300);
					System.out.println(synth.getLoadedInstruments());
				} catch (MidiUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_3.setBounds(171, 227, 74, 23);
		frame.getContentPane().add(button_3);
		
		JButton btnNewButton = new JButton("5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Synthesizer synth = null;
				try {
					synth = MidiSystem.getSynthesizer();
					MidiChannel[] mc = synth.getChannels();
					Instrument[] inst = synth.getDefaultSoundbank().getInstruments();
					synth.loadInstrument(inst[3]);
					synth.open();
					//final MidiChannel[] mc = synth.getChannels();
					mc[2].noteOn(r+7, 300);
					System.out.println(synth.getLoadedInstruments());
				} catch (MidiUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(270, 227, 74, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton button_4 = new JButton("6");
		button_4.setBackground(Color.BLACK);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Synthesizer synth = null;
				try {
					synth = MidiSystem.getSynthesizer();
					MidiChannel[] mc = synth.getChannels();
					Instrument[] inst = synth.getDefaultSoundbank().getInstruments();
					synth.loadInstrument(inst[3]);
					synth.open();
					//final MidiChannel[] mc = synth.getChannels();
					mc[2].noteOn(r+8, 300);
					System.out.println(synth.getLoadedInstruments());
				} catch (MidiUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_4.setBounds(316, 193, 74, 23);
		frame.getContentPane().add(button_4);
		
		JButton btnNewButton_1 = new JButton("7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Synthesizer synth = null;
				try {
					synth = MidiSystem.getSynthesizer();
					MidiChannel[] mc = synth.getChannels();
					Instrument[] inst = synth.getDefaultSoundbank().getInstruments();
					synth.loadInstrument(inst[3]);
					synth.open();
					//final MidiChannel[] mc = synth.getChannels();
					mc[2].noteOn(r+10, 300);
					System.out.println(synth.getLoadedInstruments());
				} catch (MidiUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(354, 227, 74, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("8");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Synthesizer synth = null;
				try {
					synth = MidiSystem.getSynthesizer();
					MidiChannel[] mc = synth.getChannels();
					Instrument[] inst = synth.getDefaultSoundbank().getInstruments();
					synth.loadInstrument(inst[3]);
					synth.open();
					//final MidiChannel[] mc = synth.getChannels();
					mc[2].noteOn(r+12, 300);
					System.out.println(synth.getLoadedInstruments());
				} catch (MidiUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(438, 227, 74, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
