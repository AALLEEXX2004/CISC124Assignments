
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A class that represents a signed 10-bit binary number represented using a
 * twos complement representation.
 *
 */
public class Declet implements Comparable<Declet> {
	
	static final int MAX_VALUE = 511;
	static final int MIN_VALUE = -512;
	static final int NUM_BIT = 10;
	
	private List<Bit> bin = new ArrayList<>();
	
	public Declet() {
		for(int i=0;i<NUM_BIT;i++) {
			this.bin.add(Bit.ZERO);
		}
			
		
	}
	
	public Declet(int decNum) {
		if(decNum>MAX_VALUE||decNum<MIN_VALUE) {
			throw new IllegalArgumentException();
		}
		int currentBitIndex = 9;
		boolean isNegative = false;
		for(int i=0;i<NUM_BIT;i++) {
			this.bin.add(Bit.ZERO);
		}
		if(decNum<0) {
			isNegative = true;
			decNum = decNum*(-1);
		}
		while(decNum!=0){
			
			if(decNum%2 == 1){
				this.bin.set(currentBitIndex,Bit.ONE);
				decNum = decNum/2;
				currentBitIndex -= 1;
			}else {
				this.bin.set(currentBitIndex,Bit.ZERO);
				decNum = decNum/2;
				currentBitIndex -= 1;
			}
		}
		if(isNegative) {
			this.not();
			this.addOne();
			}
			
		
	}
	
	public Declet(Bit ...theBits ) {
		if(theBits.length!=10) {
			throw new IllegalArgumentException();
		}
		for(int i=0;i<theBits.length;i++) {
			this.bin.add(theBits[i]);
		}
	}
	
	public void add(Declet o) {
		int oDec = o.toDecimal();
		int dec = this.toDecimal();
		int sum = dec+oDec;
		if(sum>=MAX_VALUE) {
			sum = sum-(1024);
		}
		if(sum<MIN_VALUE) {
			sum = sum+1024;
		}
		
		Declet sumBin = new Declet(sum);
		this.bin = sumBin.getBits();
	}
	
	public void addOne() {
		Bit currentBit;
		
		for(int bitIndex = NUM_BIT-1;bitIndex>=0;bitIndex--) {
			currentBit = this.bin.get(bitIndex);
			if(currentBit.equals(Bit.ZERO)) {
				this.bin.set(bitIndex, Bit.ONE);
				break;
			}else {
				this.bin.set(bitIndex, Bit.ZERO);
			}
		}
	}
	
	@Override
	public int compareTo(Declet o) {
		int dec = this.toDecimal();
		int oDec = o.toDecimal();
		if(dec>oDec) {
			return 1;
		}else if(dec == oDec) {
			return 0;
		}else {
			return -1;
		}
	}
	
	public boolean equals(Declet o) {
		if(o == null) {
			return false;
		}
		if(this.hashCode() == o.hashCode()) {
			return true;
		}else{
			return false;
		}
	}
	
	
	public List<Bit> getBits(){
		List<Bit> copy = new ArrayList<Bit>();
		copy = bin;
		return copy;
	}
	
	public int hashCode() {
		int hash = this.bin.hashCode();
		return hash;
	}
	public void not() {
		for(int i=0;i<NUM_BIT;i++) {
			Bit currentBit = this.bin.get(i);
			this.bin.set(i, currentBit.not());
		}
		
	}
	public boolean isNegative() {
		if(this.bin.get(0).equals(Bit.ONE)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public int toDecimal() {
		int decNum=0;
		int bitIndex = 0;
		
		List<Bit> copy = this.bin;
		Bit currentBit;
		boolean negative = this.isNegative();
		if(negative) {
			boolean firstOne =true;
			for(int i=9;i>=0;i--) {
				currentBit = this.bin.get(i);
				if(firstOne&&currentBit.equals(Bit.ZERO)){
					continue;
				}else if(firstOne&&currentBit.equals(Bit.ONE)) {
					firstOne = false;
					continue;
				}else {
					copy.set(i, copy.get(i).not());
				}
			}
		}
		
		
		for(int i = 9;i>=0;i--) {
			currentBit = copy.get(i);
			if(currentBit.equals(Bit.ONE)){
				decNum += (int)(Math.pow(2, bitIndex));
			}
			bitIndex++;
		}
		if(negative) {
			decNum = decNum*(-1);
		}
		return decNum;
	}
	
	public String toString() {
		String bitStrings = "";
		for(int i=0;i<this.bin.size();i++) {
			bitStrings +=this.bin.get(i).toString();
			
		}
		
		return bitStrings;
	}
	
	/**
	 * Prints some sums illustrating overflow at {@code Decle.MAX_VALUE} and
	 * {@code Decle.MIN_VALUE}.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		Declet d = new Declet(Declet.MAX_VALUE - 2);
		Declet one = new Declet(1);
		
		System.out.println("Overflow at Declet.MAX_VALUE");
		for (int i = 0; i <= 4; i++) {
			System.out.println("d       " + d + " = " + d.toDecimal());
			System.out.println("      + " + one);
			d.addOne();
			System.out.println("d + 1 = " + d + " = " + d.toDecimal());
			System.out.println();
		}
		
		Declet negOne = new Declet(-1);
		
		System.out.println("Overflow at Declet.MIN_VALUE");
		for (int i = 0; i <= 4; i++) {
			System.out.println("d     = " + d + " = " + d.toDecimal());
			System.out.println("      + " + negOne);
			d.add(negOne);
			System.out.println("d - 1 = " + d + " = " + d.toDecimal());
			System.out.println();
		}
	}










	
	


}
