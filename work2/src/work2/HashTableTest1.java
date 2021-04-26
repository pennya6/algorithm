package work2;

public class HashTableTest1 {

	public static void main(String[] args) {
		HashTable ht=new HashTable(15);
		ht.put("QR", "Qatar Airways (Q.C.S.C)");
		ht.put("SQ", "Singapore Airlines Ltd");
		ht.put("CX", "Cathay Pacific Airways Ltd");
		ht.put("EK", "Emirates");
		ht.put("KE", "Korean Air Lines Co .Ltd");
		ht.put("LH", "Lufthansa German Airlines");
		ht.put("OZ", "Asiana Airlines Inc.");
		ht.put("DL", "Delta Air Lines Inc.");
		ht.put("AHC", "Air Hawaii");
		ht.put("QF", "Qantas Airways Ltd.");

		ht.printHT();
		System.out.println(ht.get("KE"));
		
	}

}
