package a5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A class that wraps a string by breaking the string into lines
 * of length equal to or less than the desired wrapped line length.
 * The breaking occurs at spaces in the string where possible. If
 * a wrapped line contains no strings before the desired wrapped
 * line length, then the line is broken at the desired wrapped
 * line length.
 *
 */
public class SpacesWrapper extends AbstractStringWrapper {

	/**
	 * Initializes this wrapper with the string to wrap and the
	 * desired maximum wrapped line width.
	 * 
	 * @param toWrap the string to wrap
	 * @param targetWidth the desired maximum wrapped line width
	 */
	public SpacesWrapper(String toWrap, int targetWidth) {
		super(toWrap,targetWidth);
	}

	/**
	 * Wraps the string into separate lines of text.
	 * 
	 * 
	 */
	@Override
	public void wrap() {
		List<String> targetLines = new ArrayList<String>();
		Queue<String> lettersQueue = new LinkedList<String>();
		String[] letters = this.toWrap.split("");
		for(String i:letters) {
			lettersQueue.add(i);
		}
		while(!lettersQueue.isEmpty()) {
			String elem ="";
			if(lettersQueue.peek().equals(" ")) {
				lettersQueue.poll();
			}
			while(elem.length()<this.maxWidth&&(!lettersQueue.isEmpty())) {
				if(lettersQueue.peek().equals(" ")) {
					lettersQueue.poll();
					break;
				}else {
					elem = elem+lettersQueue.poll();
				}
			}
			targetLines.add(elem);
		}
		this.lines = targetLines;
		
	}

	public static void main(String[] args) {
		int width = 30;
		AbstractStringWrapper w = new SpacesWrapper("ABC DEFGH I JKLMNOPQ RSTUVWXYZ", width);
		w.wrap();
		List<String> wrapped = w.getLines();
		String out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
		
		width = 20;
		w.width(width);
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
		
		width = 5;
		w.width(width);
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
		
		width = 1;
		w.width(width);
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");

	}
}
