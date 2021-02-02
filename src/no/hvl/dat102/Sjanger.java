package no.hvl.dat102;

public enum Sjanger {
	DRAMA, COMEDY, ACTION, HORROR, FICTION, ROMANCE, THRILLER, MYSTERY, FANTASY;

	public static Sjanger finnSjanger(String navn) {
		Sjanger sjanger = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.toString().equals(navn.toUpperCase())) {
				sjanger = sj;
				break;
			}

		}
		return sjanger;

	}

}
