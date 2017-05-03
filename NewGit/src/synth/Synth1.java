package synth;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Patch;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;
import javax.sound.midi.VoiceStatus;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class Synth1 implements Synthesizer{
	Sequencer sequencer;
	private ShortMessage message = 
			new ShortMessage();
	public Synthesizer synth;
	//initialize synthesizer variable
	private Receiver receiver;
	//receiver allows midi information to be sent to a midi channel
	@Override
	public Info getDeviceInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void open() throws MidiUnavailableException {
		// runs the synthesizer in a state that waits to be passed midi information
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getMicrosecondPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxReceivers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxTransmitters() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Receiver getReceiver() throws MidiUnavailableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receiver> getReceivers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transmitter getTransmitter() throws MidiUnavailableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transmitter> getTransmitters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxPolyphony() {
		// Polyphony controls how many notes are able to play simultaneously
		return 3;
	}

	@Override
	public long getLatency() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MidiChannel[] getChannels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VoiceStatus[] getVoiceStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSoundbankSupported(Soundbank soundbank) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loadInstrument(Instrument instrument) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unloadInstrument(Instrument instrument) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remapInstrument(Instrument from, Instrument to) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Soundbank getDefaultSoundbank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instrument[] getAvailableInstruments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instrument[] getLoadedInstruments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loadAllInstruments(Soundbank soundbank) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unloadAllInstruments(Soundbank soundbank) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean loadInstruments(Soundbank soundbank, Patch[] patchList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unloadInstruments(Soundbank soundbank, Patch[] patchList) {
		// TODO Auto-generated method stub
		
	}
	//This constructor is for soundbank testing
	public Synth1(){
		try{
			synth = MidiSystem.getSynthesizer();
			synth.open();
			receiver = synth.getReceiver();
		}catch (MidiUnavailableException e1){
			e1.printStackTrace();
		}
	}
	
	private void setShortMessage(int onOrOff, int note){
		try{
			message.setMessage(onOrOff, 0, note, 70);
		}catch(InvalidMidiDataException e1){
			e1.printStackTrace();
		}
	}

	public void playNote(int note, int duration){
		setShortMessage(ShortMessage.NOTE_ON, note);
		receiver.send(message, -1);
		try{
			Thread.sleep(duration);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		setShortMessage(ShortMessage.NOTE_OFF, note);
		receiver.send(message, -1);
		//use short messages to send midi info via the receiver
	}
	
	
	public void playOctave(int baseNote){
		for (int i = 0; i<13; i++){
			playNote(baseNote + i, 200);
		}
	}
	public void loadSequencer(){

		//get default sequencer
		try {
			sequencer = MidiSystem.getSequencer();
			if(sequencer == null){
				//Error -- sequencer device is not supported
				//inform user and return
			}else{
				//Acquire resources and make operational
				sequencer.open();
			}
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		
	}	
	
	public void playMIDI(){
        try {
            Player player = new Player();
            //Pattern pattern = new Pattern("C+F D+A E+C  F+C G+C A+D B+D");
            player.play("Cw");
            player.play("C7h");
            player.play("C5maj7w");
            player.play("G5h+B5h+C6q_D6q");
            player.play("G5q G5q F5q E5q D5h");
            player.play("T[Allegro] V0 I0 G6q A5q V1 A5q G6q");
            player.play("V0 Cmajw V1 I[Flute] G4q E4q C4q E4q");
            player.play("T120 V0 I[Piano] G5q G5q V9 [Hand_Clap]q Rq"); 
            //player.play(pattern);
            //JFugue JAR allows parsing strings and converting to useful MIDI data
        } catch (final Exception e) {
            e.printStackTrace();
        }
	}

	
	public static void main(String[] args) throws IOException, InvalidMidiDataException{
		Synth1 synth1 = new Synth1();
		synth1.playMIDI();
	}
}
