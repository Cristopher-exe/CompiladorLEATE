/* The following code was generated by JFlex 1.4.3 on 3/04/22 12:10 AM */

package Backend;
import static Backend.Tokens.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 3/04/22 12:10 AM from the specification file
 * <tt>C:/Users/chico/Documents/NetBeansProjects/CompiladorLEATE2/src/Backend/Lexer.flex</tt>
 */
public class lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\4\1\10\1\0\2\4\22\0\1\4\1\61\1\0\1\7"+
    "\3\6\1\0\1\51\1\52\1\57\1\54\1\5\1\3\1\43\1\60"+
    "\1\41\1\41\1\41\1\41\1\41\1\41\1\41\3\2\1\44\1\42"+
    "\1\55\1\56\1\55\1\53\1\6\1\24\1\32\1\40\1\23\1\12"+
    "\1\16\1\31\1\20\1\21\1\1\1\36\1\22\1\27\1\14\1\15"+
    "\1\34\1\1\1\11\1\30\1\13\1\35\1\33\1\17\1\37\1\25"+
    "\1\37\1\47\1\0\1\50\1\0\1\26\1\0\1\24\1\32\1\40"+
    "\1\23\1\12\1\16\1\31\1\20\1\21\1\1\1\36\1\22\1\27"+
    "\1\14\1\15\1\34\1\1\1\11\1\30\1\13\1\35\1\33\1\17"+
    "\1\37\1\25\1\37\1\45\1\0\1\46\43\0\1\6\35\0\1\53"+
    "\1\0\1\6\7\0\1\6\3\0\1\6\3\0\1\6\1\0\1\6"+
    "\6\0\1\6\6\0\1\6\7\0\1\6\3\0\1\6\3\0\1\6"+
    "\1\0\1\6\6\0\1\6\uff05\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\2\1\3\1\4\1\5\2\6\1\2\1\6"+
    "\10\3\1\2\6\3\1\7\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\2\3\3\1\26\1\27\2\0\1\27"+
    "\1\30\1\4\1\31\1\0\1\32\1\33\11\3\1\34"+
    "\3\3\1\35\10\3\1\0\1\36\1\22\3\3\1\26"+
    "\3\3\1\26\2\3\1\26\1\37\1\26\1\30\1\40"+
    "\1\41\1\30\1\4\1\35\4\3\1\42\3\3\1\43"+
    "\3\3\1\44\1\0\10\3\2\0\3\3\1\0\1\37"+
    "\1\26\1\0\1\26\1\45\2\46\1\30\1\45\3\47"+
    "\1\50\1\3\1\51\7\3\1\35\1\52\4\3\1\53"+
    "\1\54\1\1\1\0\1\37\2\46\3\0\1\3\1\55"+
    "\1\3\1\56\1\57\1\60\2\3\1\0\2\3\1\61"+
    "\1\3\1\46\1\4\1\1\1\62\4\3\1\63\1\3"+
    "\1\1\2\3\1\64\2\3\1\0\1\65\2\3\1\66"+
    "\2\3\1\0\2\3\1\67\1\70\1\0\1\3\1\71"+
    "\1\0\1\72";

  private static int [] zzUnpackAction() {
    int [] result = new int[210];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\62\0\144\0\226\0\310\0\372\0\u012c\0\u015e"+
    "\0\u0190\0\u01c2\0\u01f4\0\u0226\0\u0258\0\u028a\0\u02bc\0\u02ee"+
    "\0\u0320\0\u0352\0\u0384\0\u03b6\0\u03e8\0\u041a\0\u044c\0\u047e"+
    "\0\62\0\u04b0\0\62\0\62\0\62\0\62\0\62\0\62"+
    "\0\62\0\62\0\u04e2\0\u0514\0\u0514\0\62\0\62\0\u0546"+
    "\0\u0578\0\u05aa\0\u05dc\0\u060e\0\u0640\0\u0672\0\u06a4\0\u06d6"+
    "\0\u0708\0\u073a\0\62\0\u076c\0\u079e\0\u07d0\0\u0802\0\u0834"+
    "\0\u0866\0\u0898\0\u08ca\0\u08fc\0\u092e\0\u0960\0\u0992\0\u0578"+
    "\0\u09c4\0\u09f6\0\u0a28\0\u0a5a\0\u0a8c\0\u0abe\0\u0af0\0\u0b22"+
    "\0\u0b54\0\u0b86\0\u0bb8\0\u0bea\0\u0c1c\0\62\0\62\0\u0c4e"+
    "\0\u0c80\0\u0cb2\0\u0ce4\0\u0d16\0\u0d48\0\u0d7a\0\u0dac\0\u0dde"+
    "\0\u0e10\0\u0e42\0\u0e74\0\u0ea6\0\u0ed8\0\u0672\0\u06a4\0\u0f0a"+
    "\0\u0f3c\0\u076c\0\u0f6e\0\u0fa0\0\u0fd2\0\u1004\0\u0c4e\0\u1036"+
    "\0\u1068\0\u109a\0\u0c4e\0\u10cc\0\u10fe\0\u1130\0\u1162\0\u1194"+
    "\0\u11c6\0\u11f8\0\u122a\0\u125c\0\u128e\0\u12c0\0\u12f2\0\u1324"+
    "\0\u1356\0\u1388\0\u13ba\0\u13ec\0\u141e\0\u1450\0\u1482\0\u14b4"+
    "\0\u14e6\0\u1518\0\u154a\0\u157c\0\u15ae\0\u15e0\0\u14e6\0\u1612"+
    "\0\u1644\0\u1676\0\u16a8\0\u16da\0\u0c4e\0\u170c\0\u173e\0\u1770"+
    "\0\u17a2\0\u17d4\0\u1806\0\u1838\0\u186a\0\u0c4e\0\u189c\0\u18ce"+
    "\0\u1900\0\u1932\0\u0cb2\0\u0c4e\0\u1964\0\u1996\0\u19c8\0\u19fa"+
    "\0\u1a2c\0\u1a5e\0\u1a90\0\u1ac2\0\u1af4\0\u0c4e\0\u1b26\0\u0c4e"+
    "\0\u0c4e\0\u0c4e\0\u1b58\0\u1b8a\0\u1bbc\0\u1bee\0\u1c20\0\u0c4e"+
    "\0\u1c52\0\u1c84\0\u1ac2\0\u1cb6\0\u0c4e\0\u1ce8\0\u1d1a\0\u1d4c"+
    "\0\u1d7e\0\u141e\0\u1db0\0\u1de2\0\u1e14\0\u1e46\0\u0c4e\0\u1e78"+
    "\0\u1eaa\0\u1edc\0\u0cb2\0\u1f0e\0\u1f40\0\u0cb2\0\u1f72\0\u1fa4"+
    "\0\u1fd6\0\u2008\0\u203a\0\u0c4e\0\u0c4e\0\u206c\0\u209e\0\u0cb2"+
    "\0\u20d0\0\u0cb2";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[210];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\6\1\12\1\13\2\3\1\14\1\15\1\16\1\3"+
    "\1\17\1\20\1\21\2\3\1\22\1\3\1\23\1\3"+
    "\1\24\1\25\1\26\1\3\1\27\1\3\1\30\1\4"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40"+
    "\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50"+
    "\63\0\1\51\1\52\6\0\15\51\1\53\12\51\1\52"+
    "\1\0\1\54\17\0\1\55\1\4\2\0\1\56\1\57"+
    "\2\0\15\55\1\60\12\55\1\4\1\0\1\61\15\0"+
    "\1\57\2\0\1\62\1\63\22\0\1\64\12\0\1\62"+
    "\24\0\2\6\2\0\1\6\53\0\1\62\1\0\2\6"+
    "\2\0\1\6\15\0\1\64\12\0\1\62\21\0\1\65"+
    "\1\66\3\0\1\65\2\0\15\65\1\0\12\65\1\66"+
    "\17\0\1\65\10\11\1\0\51\11\1\0\1\51\1\52"+
    "\6\0\1\51\1\67\13\51\1\53\12\51\1\52\1\0"+
    "\1\54\17\0\1\51\1\52\6\0\11\51\1\70\3\51"+
    "\1\53\4\51\1\71\5\51\1\52\1\0\1\54\17\0"+
    "\1\51\1\52\6\0\15\51\1\53\6\51\1\72\3\51"+
    "\1\52\1\0\1\54\17\0\1\51\1\52\6\0\4\51"+
    "\1\73\3\51\1\74\2\51\1\75\1\51\1\53\12\51"+
    "\1\52\1\0\1\54\17\0\1\51\1\52\6\0\7\51"+
    "\1\76\5\51\1\53\12\51\1\52\1\0\1\54\17\0"+
    "\1\51\1\52\6\0\3\51\1\77\1\51\1\100\7\51"+
    "\1\53\12\51\1\52\1\0\1\54\17\0\1\51\1\52"+
    "\6\0\4\51\1\101\10\51\1\53\12\51\1\52\1\0"+
    "\1\54\17\0\1\51\1\52\6\0\1\51\1\102\6\51"+
    "\1\103\4\51\1\53\12\51\1\52\1\0\1\54\20\0"+
    "\1\104\36\0\1\104\21\0\1\51\1\52\6\0\2\51"+
    "\1\105\12\51\1\53\12\51\1\52\1\0\1\54\17\0"+
    "\1\51\1\52\6\0\4\51\1\106\10\51\1\53\12\51"+
    "\1\52\1\0\1\54\17\0\1\51\1\52\6\0\1\51"+
    "\1\107\13\51\1\53\12\51\1\52\1\0\1\54\17\0"+
    "\1\51\1\52\6\0\10\51\1\110\4\51\1\53\6\51"+
    "\1\111\3\51\1\52\1\0\1\54\17\0\1\51\1\52"+
    "\6\0\1\51\1\112\13\51\1\53\5\51\1\113\4\51"+
    "\1\52\1\0\1\54\17\0\1\51\1\52\6\0\13\51"+
    "\1\114\1\51\1\53\12\51\1\52\1\0\1\54\20\0"+
    "\1\115\36\0\1\115\22\0\1\62\23\0\1\64\12\0"+
    "\1\62\12\0\1\116\63\0\1\117\4\0\1\65\1\66"+
    "\3\0\1\65\2\0\15\65\1\0\12\65\1\66\14\0"+
    "\1\117\2\0\1\65\1\0\1\120\1\121\6\0\15\120"+
    "\1\122\12\120\1\121\1\0\1\123\17\0\1\124\1\125"+
    "\6\0\15\124\1\126\12\124\1\125\1\0\1\127\17\0"+
    "\1\130\1\131\6\0\15\130\1\53\12\130\1\131\21\0"+
    "\1\132\1\133\6\0\15\132\1\134\12\132\1\133\21\0"+
    "\1\55\1\60\6\0\15\55\1\60\12\55\1\60\1\0"+
    "\1\135\20\0\1\136\36\0\1\136\22\0\1\137\36\0"+
    "\1\137\21\0\2\60\6\0\31\60\21\0\1\140\1\141"+
    "\6\0\15\140\1\0\12\140\1\141\22\0\1\62\36\0"+
    "\1\62\22\0\1\142\36\0\1\142\21\0\1\65\4\0"+
    "\1\65\2\0\15\65\1\0\12\65\20\0\1\65\2\0"+
    "\1\66\36\0\1\66\21\0\1\120\1\121\6\0\2\120"+
    "\1\143\12\120\1\122\12\120\1\121\1\0\1\123\17\0"+
    "\1\120\1\121\6\0\15\120\1\122\1\120\1\144\10\120"+
    "\1\121\1\0\1\123\17\0\1\120\1\121\6\0\1\120"+
    "\1\145\13\120\1\122\12\120\1\121\1\0\1\123\17\0"+
    "\1\120\1\121\6\0\2\120\1\146\12\120\1\122\12\120"+
    "\1\121\1\0\1\123\17\0\1\120\1\121\6\0\1\147"+
    "\14\120\1\122\12\120\1\121\1\0\1\123\17\0\1\120"+
    "\1\121\6\0\3\120\1\150\11\120\1\122\12\120\1\121"+
    "\1\0\1\123\17\0\1\120\1\121\6\0\11\120\1\151"+
    "\3\120\1\122\12\120\1\121\1\0\1\123\17\0\1\120"+
    "\1\121\6\0\10\120\1\152\4\120\1\122\12\120\1\121"+
    "\1\0\1\123\17\0\1\120\1\121\6\0\2\120\1\153"+
    "\12\120\1\122\12\120\1\121\1\0\1\123\17\0\1\120"+
    "\1\121\6\0\3\120\1\154\11\120\1\122\12\120\1\121"+
    "\1\0\1\123\17\0\1\120\1\121\6\0\11\120\1\155"+
    "\3\120\1\122\12\120\1\121\1\0\1\123\17\0\1\120"+
    "\1\121\6\0\15\120\1\122\1\120\1\156\10\120\1\121"+
    "\1\0\1\123\17\0\1\157\1\104\6\0\30\157\1\104"+
    "\1\0\1\160\17\0\1\120\1\121\6\0\13\120\1\161"+
    "\1\120\1\122\12\120\1\121\1\0\1\123\17\0\1\120"+
    "\1\121\6\0\4\120\1\162\10\120\1\122\12\120\1\121"+
    "\1\0\1\123\17\0\1\120\1\121\6\0\1\163\14\120"+
    "\1\122\12\120\1\121\1\0\1\123\17\0\1\120\1\121"+
    "\6\0\3\120\1\164\11\120\1\122\12\120\1\121\1\0"+
    "\1\123\17\0\1\120\1\121\6\0\11\120\1\165\3\120"+
    "\1\122\12\120\1\121\1\0\1\123\17\0\1\120\1\121"+
    "\6\0\14\120\1\166\1\122\12\120\1\121\1\0\1\123"+
    "\17\0\1\120\1\121\6\0\15\120\1\167\12\120\1\121"+
    "\1\0\1\123\17\0\1\120\1\121\6\0\15\120\1\122"+
    "\1\120\1\170\10\120\1\121\1\0\1\123\20\0\1\115"+
    "\7\0\1\171\26\0\1\115\21\0\1\120\1\121\6\0"+
    "\15\120\1\122\12\120\1\121\1\0\1\172\17\0\1\173"+
    "\1\174\6\0\30\173\1\174\1\0\1\127\17\0\1\122"+
    "\1\175\6\0\30\122\1\175\21\0\1\176\1\177\6\0"+
    "\15\176\1\200\12\176\1\177\21\0\2\173\6\0\31\173"+
    "\1\0\1\200\17\0\1\124\1\125\6\0\15\124\1\126"+
    "\12\124\1\125\1\0\1\201\17\0\1\124\1\126\6\0"+
    "\15\124\1\126\12\124\1\126\21\0\1\202\1\203\6\0"+
    "\30\202\1\203\21\0\1\122\1\175\6\0\30\122\1\175"+
    "\1\0\1\200\17\0\1\124\1\126\6\0\15\124\1\126"+
    "\12\124\1\126\1\0\1\202\17\0\1\132\1\204\6\0"+
    "\15\132\1\134\12\132\1\204\21\0\1\205\1\133\6\0"+
    "\15\205\1\134\12\205\1\133\21\0\2\134\6\0\31\134"+
    "\21\0\1\206\1\207\6\0\15\206\1\0\12\206\1\207"+
    "\21\0\1\140\1\210\6\0\15\140\1\0\12\140\1\210"+
    "\21\0\1\211\1\141\6\0\1\211\1\212\13\211\1\0"+
    "\12\211\1\141\1\0\1\213\17\0\1\120\1\121\6\0"+
    "\3\120\1\214\11\120\1\122\12\120\1\121\1\0\1\172"+
    "\17\0\1\120\1\121\6\0\1\120\1\215\13\120\1\122"+
    "\12\120\1\121\1\0\1\172\17\0\1\120\1\121\6\0"+
    "\3\120\1\216\11\120\1\122\12\120\1\121\1\0\1\172"+
    "\17\0\1\120\1\121\6\0\15\120\1\122\5\120\1\217"+
    "\4\120\1\121\1\0\1\172\17\0\1\120\1\121\6\0"+
    "\13\120\1\220\1\120\1\122\12\120\1\121\1\0\1\172"+
    "\17\0\1\120\1\121\6\0\15\120\1\122\1\120\1\221"+
    "\10\120\1\121\1\0\1\172\17\0\1\120\1\121\6\0"+
    "\11\120\1\222\3\120\1\122\12\120\1\121\1\0\1\172"+
    "\17\0\1\120\1\121\6\0\15\120\1\122\2\120\1\153"+
    "\7\120\1\121\1\0\1\172\17\0\1\120\1\121\6\0"+
    "\13\120\1\223\1\120\1\122\12\120\1\121\1\0\1\172"+
    "\17\0\1\120\1\121\6\0\15\120\1\122\5\120\1\224"+
    "\4\120\1\121\1\0\1\172\17\0\2\157\6\0\31\157"+
    "\22\0\1\225\36\0\1\225\21\0\1\120\1\121\6\0"+
    "\1\226\14\120\1\122\12\120\1\121\1\0\1\172\17\0"+
    "\1\120\1\121\6\0\11\120\1\153\3\120\1\122\12\120"+
    "\1\121\1\0\1\172\17\0\1\120\1\121\6\0\12\120"+
    "\1\227\2\120\1\122\12\120\1\121\1\0\1\172\17\0"+
    "\1\120\1\121\6\0\15\120\1\230\12\120\1\121\1\0"+
    "\1\172\17\0\1\120\1\121\6\0\15\120\1\122\1\120"+
    "\1\231\10\120\1\121\1\0\1\172\17\0\1\120\1\121"+
    "\6\0\15\120\1\122\5\120\1\232\4\120\1\121\1\0"+
    "\1\172\17\0\1\122\1\175\6\0\3\122\1\233\12\122"+
    "\1\233\2\122\2\233\3\122\2\233\1\175\21\0\1\120"+
    "\1\121\6\0\4\120\1\234\10\120\1\122\12\120\1\121"+
    "\1\0\1\172\21\0\1\235\50\0\1\235\6\0\1\236"+
    "\1\237\6\0\15\236\1\0\12\236\1\237\21\0\2\173"+
    "\6\0\31\173\21\0\1\173\1\174\6\0\30\173\1\174"+
    "\1\0\1\201\17\0\2\173\6\0\31\173\1\0\1\202"+
    "\17\0\1\236\1\240\6\0\15\236\1\0\12\236\1\240"+
    "\1\0\1\200\17\0\1\241\1\177\6\0\15\241\1\200"+
    "\12\241\1\177\21\0\1\242\1\200\6\0\15\242\1\200"+
    "\12\242\1\200\22\0\1\207\36\0\1\207\21\0\1\202"+
    "\1\243\6\0\30\202\1\243\22\0\1\207\36\0\1\207"+
    "\1\0\1\202\17\0\1\134\1\204\6\0\30\134\1\204"+
    "\21\0\1\205\1\134\6\0\15\205\1\134\12\205\1\134"+
    "\21\0\1\206\7\0\15\206\1\0\12\206\23\0\1\210"+
    "\36\0\1\210\21\0\1\211\7\0\15\211\1\0\12\211"+
    "\22\0\1\211\1\62\1\244\5\0\15\211\1\0\12\211"+
    "\1\62\12\0\1\244\7\0\1\213\36\0\1\213\1\0"+
    "\1\213\17\0\1\120\1\121\6\0\4\120\1\245\10\120"+
    "\1\122\12\120\1\121\1\0\1\172\17\0\1\120\1\121"+
    "\6\0\2\120\1\246\12\120\1\122\12\120\1\121\1\0"+
    "\1\172\17\0\1\120\1\121\6\0\15\120\1\122\6\120"+
    "\1\247\3\120\1\121\1\0\1\172\17\0\1\120\1\121"+
    "\6\0\11\120\1\250\3\120\1\122\12\120\1\121\1\0"+
    "\1\172\17\0\1\120\1\121\6\0\4\120\1\251\10\120"+
    "\1\122\12\120\1\121\1\0\1\172\17\0\1\120\1\121"+
    "\6\0\1\120\1\252\13\120\1\122\12\120\1\121\1\0"+
    "\1\172\17\0\1\120\1\121\6\0\14\120\1\253\1\122"+
    "\12\120\1\121\1\0\1\172\17\0\1\120\1\121\6\0"+
    "\11\120\1\254\3\120\1\122\12\120\1\121\1\0\1\172"+
    "\20\0\1\225\7\0\1\255\26\0\1\225\21\0\1\120"+
    "\1\121\6\0\13\120\1\256\1\120\1\122\12\120\1\121"+
    "\1\0\1\172\17\0\1\122\1\175\6\0\21\122\1\257"+
    "\6\122\1\175\21\0\1\120\1\121\6\0\13\120\1\260"+
    "\1\120\1\122\12\120\1\121\1\0\1\172\17\0\1\120"+
    "\1\121\6\0\11\120\1\261\3\120\1\122\12\120\1\121"+
    "\1\0\1\172\20\0\1\235\36\0\1\235\21\0\1\236"+
    "\1\240\6\0\15\236\1\0\12\236\1\240\21\0\1\262"+
    "\1\237\6\0\15\262\1\0\12\262\1\237\22\0\1\240"+
    "\36\0\1\240\21\0\1\262\7\0\15\262\1\0\12\262"+
    "\2\0\1\200\61\0\1\200\61\0\1\202\20\0\1\263"+
    "\36\0\1\263\1\0\1\264\17\0\1\120\1\121\6\0"+
    "\2\120\1\265\12\120\1\122\12\120\1\121\1\0\1\172"+
    "\17\0\1\120\1\121\6\0\2\120\1\266\12\120\1\122"+
    "\12\120\1\121\1\0\1\172\17\0\1\120\1\121\6\0"+
    "\15\120\1\267\12\120\1\121\1\0\1\172\17\0\1\120"+
    "\1\121\6\0\13\120\1\270\1\120\1\122\12\120\1\121"+
    "\1\0\1\172\20\0\1\142\1\64\35\0\1\142\12\0"+
    "\1\64\6\0\1\120\1\121\6\0\12\120\1\271\2\120"+
    "\1\122\12\120\1\121\1\0\1\172\17\0\1\122\1\175"+
    "\6\0\30\122\1\272\21\0\1\120\1\121\6\0\13\120"+
    "\1\273\1\120\1\122\12\120\1\121\1\0\1\172\17\0"+
    "\1\262\7\0\15\262\1\0\12\262\23\0\1\274\36\0"+
    "\1\274\21\0\1\120\1\121\6\0\15\120\1\275\12\120"+
    "\1\121\1\0\1\172\17\0\1\122\1\175\6\0\16\122"+
    "\1\276\11\122\1\175\21\0\1\120\1\121\6\0\14\120"+
    "\1\277\1\122\12\120\1\121\1\0\1\172\17\0\1\120"+
    "\1\121\6\0\1\120\1\300\13\120\1\122\12\120\1\121"+
    "\1\0\1\172\17\0\1\120\1\121\6\0\14\120\1\301"+
    "\1\122\12\120\1\121\1\0\1\172\20\0\1\274\36\0"+
    "\1\274\1\0\1\302\17\0\1\122\1\175\6\0\3\122"+
    "\1\303\3\122\1\304\1\122\1\305\16\122\1\175\21\0"+
    "\1\122\1\175\6\0\17\122\1\306\10\122\1\175\21\0"+
    "\1\120\1\121\6\0\1\307\14\120\1\122\12\120\1\121"+
    "\1\0\1\172\17\0\1\120\1\121\6\0\1\120\1\310"+
    "\13\120\1\122\12\120\1\121\1\0\1\172\20\0\1\311"+
    "\36\0\1\311\21\0\1\122\1\175\6\0\10\122\1\312"+
    "\17\122\1\175\21\0\1\122\1\175\6\0\4\122\1\313"+
    "\23\122\1\175\21\0\1\120\1\121\6\0\4\120\1\314"+
    "\10\120\1\122\12\120\1\121\1\0\1\172\17\0\1\120"+
    "\1\121\6\0\12\120\1\315\2\120\1\122\12\120\1\121"+
    "\1\0\1\172\20\0\1\311\7\0\1\316\26\0\1\311"+
    "\21\0\1\122\1\175\6\0\20\122\1\317\7\122\1\175"+
    "\21\0\1\122\1\175\6\0\6\122\1\320\21\122\1\175"+
    "\23\0\1\321\50\0\1\321\6\0\1\122\1\175\6\0"+
    "\7\122\1\322\20\122\1\175\22\0\1\321\36\0\1\321"+
    "\1\0\1\264\16\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8450];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\1\1\11\26\1\1\11\1\1\10\11\3\1\2\11"+
    "\6\1\2\0\3\1\1\11\1\0\30\1\1\0\2\11"+
    "\40\1\1\0\10\1\2\0\3\1\1\0\2\1\1\0"+
    "\34\1\1\0\3\1\3\0\10\1\1\0\24\1\1\0"+
    "\6\1\1\0\4\1\1\0\2\1\1\0\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[210];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexeme;
    public int line;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public lexer(java.io.Reader in) {
      yyline = 1;
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 250) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 10: 
          { lexeme=yytext(); line=yyline; return Llave_a;
          }
        case 59: break;
        case 20: 
          { lexeme=yytext(); line=yyline; return Op_Multiplicacion;
          }
        case 60: break;
        case 51: 
          { lexeme=yytext(); line=yyline; return pines_B;
          }
        case 61: break;
        case 7: 
          { lexeme=yytext(); line=yyline; return P_coma;
          }
        case 62: break;
        case 9: 
          { lexeme=yytext(); line=yyline; return dosPuntos;
          }
        case 63: break;
        case 26: 
          { lexeme=yytext(); line=yyline; return ERRORL_002;
          }
        case 64: break;
        case 37: 
          { lexeme=yytext(); line=yyline; return ERRORL_005;
          }
        case 65: break;
        case 52: 
          { lexeme=yytext(); line=yyline; return Display;
          }
        case 66: break;
        case 56: 
          { lexeme=yytext(); line=yyline; return KeyPlayed;
          }
        case 67: break;
        case 24: 
          { lexeme=yytext(); line=yyline; return ERRORL_008;
          }
        case 68: break;
        case 6: 
          { /*Ignorar*/
          }
        case 69: break;
        case 21: 
          { lexeme=yytext(); line=yyline; return Op_Division;
          }
        case 70: break;
        case 5: 
          { lexeme=yytext(); line=yyline; return Op_Resta;
          }
        case 71: break;
        case 45: 
          { lexeme=yytext(); line=yyline; return event;
          }
        case 72: break;
        case 41: 
          { lexeme=yytext(); line=yyline; return Else;
          }
        case 73: break;
        case 44: 
          { lexeme=yytext(); line=yyline; return caso;
          }
        case 74: break;
        case 54: 
          { lexeme=yytext(); line=yyline; return delay_ms;
          }
        case 75: break;
        case 3: 
          { lexeme=yytext(); line=yyline; return Identificador;
          }
        case 76: break;
        case 27: 
          { lexeme=yytext(); line=yyline; return ERRORL_011;
          }
        case 77: break;
        case 18: 
          { lexeme=yytext(); line=yyline; return Op_relacional;
          }
        case 78: break;
        case 36: 
          { lexeme=yytext(); line=yyline; return ERRORL_014;
          }
        case 79: break;
        case 25: 
          { lexeme=yytext(); line=yyline; return Op_decremento;
          }
        case 80: break;
        case 57: 
          { lexeme=yytext(); line=yyline; return output_low;
          }
        case 81: break;
        case 11: 
          { lexeme=yytext(); line=yyline; return Llave_c;
          }
        case 82: break;
        case 28: 
          { lexeme=yytext(); line=yyline; return If;
          }
        case 83: break;
        case 58: 
          { lexeme=yytext(); line=yyline; return output_high;
          }
        case 84: break;
        case 30: 
          { lexeme=yytext(); line=yyline; return Op_incremento;
          }
        case 85: break;
        case 53: 
          { lexeme=yytext(); line=yyline; return output_N;
          }
        case 86: break;
        case 23: 
          { lexeme=yytext(); line=yyline; return ERRORL_001;
          }
        case 87: break;
        case 4: 
          { lexeme=yytext(); line=yyline; return Numero;
          }
        case 88: break;
        case 43: 
          { lexeme=yytext(); line=yyline; return Kp_Teclado;
          }
        case 89: break;
        case 1: 
          { lexeme=yytext(); line=yyline; return ERRORL_004;
          }
        case 90: break;
        case 47: 
          { lexeme=yytext(); line=yyline; return Valor_fal;
          }
        case 91: break;
        case 38: 
          { lexeme=yytext(); line=yyline; return ERRORL_007;
          }
        case 92: break;
        case 14: 
          { lexeme=yytext(); line=yyline; return parentesis_a;
          }
        case 93: break;
        case 48: 
          { lexeme=yytext(); line=yyline; return While;
          }
        case 94: break;
        case 46: 
          { lexeme=yytext(); line=yyline; return Final;
          }
        case 95: break;
        case 19: 
          { lexeme=yytext(); line=yyline; return Op_asig;
          }
        case 96: break;
        case 55: 
          { lexeme=yytext(); line=yyline; return Valor_ver;
          }
        case 97: break;
        case 31: 
          { lexeme=yytext(); line=yyline; return ERRORL_010;
          }
        case 98: break;
        case 12: 
          { lexeme=yytext(); line=yyline; return Corchete_a;
          }
        case 99: break;
        case 29: 
          { lexeme=yytext(); line=yyline; return ERRORL_013;
          }
        case 100: break;
        case 49: 
          { lexeme=yytext(); line=yyline; return pulsa;
          }
        case 101: break;
        case 22: 
          { lexeme=yytext(); line=yyline; return ERRORL_016;
          }
        case 102: break;
        case 35: 
          { lexeme=yytext(); line=yyline; return T_dato;
          }
        case 103: break;
        case 16: 
          { lexeme=yytext(); line=yyline; return Sig_Agru;
          }
        case 104: break;
        case 17: 
          { lexeme=yytext(); line=yyline; return Op_Suma;
          }
        case 105: break;
        case 2: 
          { lexeme=yytext(); line=yyline; return ERRORL_000;
          }
        case 106: break;
        case 50: 
          { lexeme=yytext(); line=yyline; return retnot;
          }
        case 107: break;
        case 40: 
          { lexeme=yytext(); line=yyline; return ERRORL_003;
          }
        case 108: break;
        case 39: 
          { lexeme=yytext(); line=yyline; return ERRORL_006;
          }
        case 109: break;
        case 42: 
          { lexeme=yytext(); line=yyline; return star;
          }
        case 110: break;
        case 32: 
          { lexeme=yytext(); line=yyline; return ERRORL_009;
          }
        case 111: break;
        case 8: 
          { lexeme=yytext(); line=yyline; return TK_punto;
          }
        case 112: break;
        case 15: 
          { lexeme=yytext(); line=yyline; return parentesis_c;
          }
        case 113: break;
        case 34: 
          { lexeme=yytext(); line=yyline; return For;
          }
        case 114: break;
        case 33: 
          { lexeme=yytext(); line=yyline; return ERRORL_012;
          }
        case 115: break;
        case 13: 
          { lexeme=yytext(); line=yyline; return Corchete_c;
          }
        case 116: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
