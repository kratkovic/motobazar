interface Print {}
enum Symbol implements Print{
	Y
}
class Q40{
	public static void main (String []args) {
		if (Symbol.Y instanceof Print p) {
			System.out.print(p + "P ");
		}
		if(Symbol.Y instanceof Enum e) {
			System.out.print(e + "E ");
		}
		if (Symbol.Y instanceof Symbol s) {
			System.out.print(s + "S ");
			
		}
	}
}