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
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;
import javax.sound.midi.VoiceStatus;
import javax.sound.midi.Soundbank;

public class Synth1 implements Synthesizer{
	
	private ShortMessage message = 
			new ShortMessage();
	public Synthesizer synth;
	
	private Receiver receiver;

	@Override
	public Info getDeviceInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void open() throws MidiUnavailableException {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
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
	}
	
	public void setInstrument(int instrument, Soundbank soundbank){
		synth.unloadAllInstruments(soundbank);
		synth.loadAllInstruments(soundbank);
		synth.getChannels()[0].programChange(instrument);
	}
	
	public void playOctave(int baseNote){
		for (int i = 0; i<13; i++){
			playNote(baseNote + i, 200);
		}
	}
	
	public static void main(String[] args) throws IOException, InvalidMidiDataException{
		Synth1 synth1 = new Synth1();
		//synth1.setInstrument(3, MidiSystem.getSoundbank(new File("C://Program Files//Java//jdk1.8.0_101//jre//lib//audio//soundbank.gm")));
		synth1.setInstrument(3, MidiSystem.getSoundbank(new File("soundbank.gm")));
		synth1.playOctave(60);
		
	}
}
