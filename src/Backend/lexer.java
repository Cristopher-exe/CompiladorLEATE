/* The following code was generated by JFlex 1.4.3 on 25/11/21 03:56 PM */

package Backend;
import static Backend.Tokens.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 25/11/21 03:56 PM from the specification file
 * <tt>D:/Cristopher/Documentos/NetBeansProjects/Compilador_LEATE/src/Backend/Lexer.flex</tt>
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
    "\11\0\1\4\1\10\1\0\2\4\22\0\1\4\1\13\1\0\1\7"+
    "\3\6\1\44\1\46\1\46\1\11\1\50\1\5\1\3\1\45\1\11"+
    "\1\2\1\43\1\43\1\43\1\43\1\43\1\43\3\2\1\44\1\44"+
    "\1\51\1\52\1\51\1\47\1\6\1\25\1\42\1\14\1\32\1\17"+
    "\1\27\1\35\1\31\1\24\1\1\1\37\1\22\1\16\1\20\1\15"+
    "\1\36\1\1\1\26\1\12\1\23\1\21\1\41\1\30\1\40\1\33"+
    "\1\40\1\46\1\0\1\46\1\0\1\34\1\0\1\25\1\42\1\14"+
    "\1\32\1\17\1\27\1\35\1\31\1\24\1\1\1\37\1\22\1\16"+
    "\1\20\1\15\1\36\1\1\1\26\1\12\1\23\1\21\1\41\1\30"+
    "\1\40\1\33\1\40\1\46\1\0\1\46\43\0\1\6\35\0\1\46"+
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
    "\1\1\2\2\1\3\1\4\2\5\1\2\1\5\1\4"+
    "\15\2\2\6\2\7\1\4\1\10\1\11\3\12\1\0"+
    "\1\13\1\0\1\14\1\3\1\15\1\16\1\12\1\17"+
    "\7\12\1\20\12\12\1\0\1\21\1\10\2\0\1\22"+
    "\1\13\1\14\1\23\1\14\1\3\20\12\1\0\1\24"+
    "\2\25\1\14\3\26\1\27\11\12\1\20\1\1\1\0"+
    "\6\12\1\3\1\1\5\12\1\1\4\12\1\0\4\12"+
    "\1\0\3\12\1\0\2\12\1\0\4\12\1\5";

  private static int [] zzUnpackAction() {
    int [] result = new int[144];
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
    "\0\0\0\53\0\126\0\201\0\254\0\327\0\u0102\0\u012d"+
    "\0\u0158\0\53\0\u0183\0\u01ae\0\u01d9\0\u0204\0\u022f\0\u025a"+
    "\0\u0285\0\u02b0\0\u02db\0\u0306\0\u0331\0\u035c\0\u0387\0\53"+
    "\0\u03b2\0\53\0\u012d\0\u03dd\0\u0408\0\u0408\0\126\0\u0433"+
    "\0\u045e\0\u0489\0\u04b4\0\u04df\0\u050a\0\u0535\0\53\0\u012d"+
    "\0\u0560\0\53\0\u058b\0\u05b6\0\u05e1\0\u060c\0\u0637\0\u0662"+
    "\0\u068d\0\126\0\u06b8\0\u06e3\0\u070e\0\u0739\0\u0764\0\u078f"+
    "\0\u07ba\0\u07e5\0\u0810\0\u083b\0\u0866\0\53\0\53\0\u0891"+
    "\0\u08bc\0\u08e7\0\u0912\0\u093d\0\u04df\0\u0968\0\u0993\0\u09be"+
    "\0\u09e9\0\u0a14\0\u0a3f\0\u0a6a\0\u0a95\0\u0ac0\0\u0aeb\0\u0b16"+
    "\0\u0b41\0\u0b6c\0\u0b97\0\u0bc2\0\u0bed\0\u0c18\0\u0c43\0\u0c6e"+
    "\0\u0891\0\u0c99\0\u0cc4\0\u0cef\0\u0d1a\0\u0d45\0\u0d70\0\u0d9b"+
    "\0\u0dc6\0\u0df1\0\u0e1c\0\u0e47\0\u0e72\0\u0e9d\0\u0ec8\0\u0ef3"+
    "\0\u0f1e\0\u045e\0\u0f49\0\u0f74\0\u0f9f\0\u0fca\0\u0ff5\0\u1020"+
    "\0\u104b\0\u1076\0\u0f74\0\u10a1\0\u10cc\0\u10f7\0\u1122\0\u114d"+
    "\0\u1178\0\u11a3\0\u11ce\0\u11f9\0\u1224\0\u124f\0\u127a\0\u12a5"+
    "\0\u12d0\0\u12fb\0\u1326\0\u1351\0\u137c\0\u13a7\0\u13d2\0\u13fd"+
    "\0\u1428\0\u1453\0\u147e\0\u14a9\0\u14d4\0\u14ff\0\u152a\0\126";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[144];
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
    "\1\6\1\12\1\13\1\14\1\15\1\16\1\3\1\17"+
    "\2\3\1\20\1\3\1\21\1\3\1\22\1\23\1\24"+
    "\1\3\1\25\1\3\1\2\1\3\1\26\1\27\3\3"+
    "\1\4\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\54\0\1\37\1\40\7\0\1\37\1\0\20\37\1\41"+
    "\6\37\1\40\1\0\1\42\6\0\1\43\1\4\2\0"+
    "\1\44\4\0\1\43\1\0\20\43\1\0\6\43\1\4"+
    "\1\0\1\45\7\0\1\46\1\47\37\0\1\46\13\0"+
    "\2\6\2\0\1\6\44\0\1\46\1\0\2\6\2\0"+
    "\1\6\32\0\1\46\10\0\2\50\3\0\1\50\3\0"+
    "\22\50\1\0\7\50\3\0\1\50\3\0\10\11\1\0"+
    "\42\11\1\0\1\37\1\40\7\0\1\37\1\0\7\37"+
    "\1\51\10\37\1\41\6\37\1\40\1\0\1\42\6\0"+
    "\2\50\3\0\1\50\3\0\22\50\1\0\7\50\3\0"+
    "\1\50\2\0\1\52\1\0\1\37\1\40\7\0\1\37"+
    "\1\0\1\37\1\53\7\37\1\54\6\37\1\41\6\37"+
    "\1\40\1\0\1\42\6\0\1\37\1\40\7\0\1\37"+
    "\1\0\5\37\1\55\12\37\1\41\6\37\1\40\1\0"+
    "\1\42\6\0\1\37\1\40\7\0\1\37\1\0\6\37"+
    "\1\56\11\37\1\41\4\37\1\57\1\37\1\40\1\0"+
    "\1\42\6\0\1\37\1\40\7\0\1\37\1\0\1\37"+
    "\1\60\16\37\1\41\6\37\1\40\1\0\1\42\6\0"+
    "\1\37\1\40\7\0\1\37\1\0\4\37\1\61\6\37"+
    "\1\62\4\37\1\41\6\37\1\40\1\0\1\42\6\0"+
    "\1\37\1\40\7\0\1\37\1\0\3\37\1\63\14\37"+
    "\1\41\6\37\1\40\1\0\1\42\6\0\1\37\1\40"+
    "\7\0\1\37\1\0\1\37\1\64\6\37\1\65\7\37"+
    "\1\41\6\37\1\40\1\0\1\42\6\0\1\37\1\40"+
    "\7\0\1\37\1\0\15\37\1\66\2\37\1\41\6\37"+
    "\1\40\1\0\1\42\6\0\1\37\1\40\7\0\1\37"+
    "\1\0\3\37\1\67\4\37\1\70\7\37\1\41\6\37"+
    "\1\40\1\0\1\42\6\0\1\37\1\40\7\0\1\37"+
    "\1\0\5\37\1\71\2\37\1\72\7\37\1\41\6\37"+
    "\1\40\1\0\1\42\6\0\1\37\1\40\7\0\1\37"+
    "\1\0\3\37\1\73\14\37\1\41\1\37\1\74\4\37"+
    "\1\40\1\0\1\42\7\0\1\75\40\0\1\75\11\0"+
    "\1\46\40\0\1\46\4\0\1\76\54\0\1\77\1\0"+
    "\1\41\1\40\7\0\1\41\1\0\27\41\1\40\1\0"+
    "\1\100\6\0\2\41\7\0\1\41\1\0\30\41\10\0"+
    "\1\101\1\102\7\0\1\101\1\0\20\101\1\0\6\101"+
    "\1\102\10\0\1\43\1\103\7\0\1\43\1\0\20\43"+
    "\1\0\6\43\1\103\1\0\1\104\7\0\1\105\40\0"+
    "\1\105\10\0\1\106\1\107\7\0\1\106\1\0\20\106"+
    "\1\0\6\106\1\107\11\0\1\46\40\0\1\46\10\0"+
    "\1\37\1\40\7\0\1\37\1\0\11\37\1\110\6\37"+
    "\1\41\6\37\1\40\1\0\1\42\6\0\1\37\1\40"+
    "\7\0\1\37\1\0\2\37\1\111\15\37\1\41\6\37"+
    "\1\40\1\0\1\42\6\0\1\37\1\40\7\0\1\112"+
    "\1\0\20\37\1\41\6\37\1\40\1\0\1\42\6\0"+
    "\1\37\1\40\7\0\1\37\1\0\7\37\1\113\10\37"+
    "\1\41\6\37\1\40\1\0\1\42\6\0\1\37\1\40"+
    "\7\0\1\114\1\0\20\37\1\41\6\37\1\40\1\0"+
    "\1\42\6\0\1\37\1\40\7\0\1\37\1\0\3\37"+
    "\1\115\14\37\1\41\6\37\1\40\1\0\1\42\6\0"+
    "\1\37\1\40\7\0\1\37\1\0\4\37\1\116\13\37"+
    "\1\41\6\37\1\40\1\0\1\42\6\0\1\37\1\40"+
    "\7\0\1\37\1\0\7\37\1\62\10\37\1\41\6\37"+
    "\1\40\1\0\1\42\6\0\1\37\1\40\7\0\1\37"+
    "\1\0\7\37\1\117\10\37\1\41\6\37\1\40\1\0"+
    "\1\42\6\0\1\37\1\40\7\0\1\37\1\0\12\37"+
    "\1\62\5\37\1\41\6\37\1\40\1\0\1\42\6\0"+
    "\1\37\1\40\7\0\1\37\1\0\4\37\1\120\13\37"+
    "\1\41\6\37\1\40\1\0\1\42\6\0\1\37\1\40"+
    "\7\0\1\37\1\0\10\37\1\121\7\37\1\41\6\37"+
    "\1\40\1\0\1\42\6\0\1\37\1\40\7\0\1\37"+
    "\1\0\6\37\1\122\11\37\1\41\6\37\1\40\1\0"+
    "\1\42\6\0\1\37\1\40\7\0\1\123\1\0\20\37"+
    "\1\41\6\37\1\40\1\0\1\42\6\0\1\37\1\40"+
    "\7\0\1\37\1\0\6\37\1\124\11\37\1\41\6\37"+
    "\1\40\1\0\1\42\6\0\1\37\1\40\7\0\1\37"+
    "\1\0\4\37\1\125\13\37\1\41\6\37\1\40\1\0"+
    "\1\42\6\0\1\37\1\40\7\0\1\37\1\0\17\37"+
    "\1\126\1\41\6\37\1\40\1\0\1\42\6\0\1\37"+
    "\1\40\7\0\1\37\1\0\20\37\1\127\6\37\1\40"+
    "\1\0\1\42\7\0\1\75\14\0\1\130\23\0\1\75"+
    "\11\0\1\131\40\0\1\131\10\0\1\101\1\132\7\0"+
    "\1\101\1\0\20\101\1\0\6\101\1\132\10\0\1\133"+
    "\1\102\7\0\1\133\1\0\20\133\1\0\6\133\1\102"+
    "\10\0\2\103\7\0\1\103\1\0\20\103\1\0\7\103"+
    "\10\0\1\134\1\131\7\0\1\134\1\0\20\134\1\0"+
    "\6\134\1\131\10\0\1\106\1\135\7\0\1\106\1\0"+
    "\20\106\1\0\6\106\1\135\10\0\1\136\1\107\7\0"+
    "\1\136\1\0\3\136\1\137\14\136\1\0\6\136\1\107"+
    "\1\0\1\140\6\0\1\37\1\40\7\0\1\37\1\0"+
    "\12\37\1\61\5\37\1\41\6\37\1\40\1\0\1\42"+
    "\6\0\1\37\1\40\7\0\1\37\1\0\3\37\1\141"+
    "\14\37\1\41\6\37\1\40\1\0\1\42\6\0\1\37"+
    "\1\40\7\0\1\37\1\0\1\37\1\62\16\37\1\41"+
    "\6\37\1\40\1\0\1\42\6\0\1\37\1\40\7\0"+
    "\1\37\1\0\20\37\1\41\1\37\1\142\4\37\1\40"+
    "\1\0\1\42\6\0\1\37\1\40\7\0\1\37\1\0"+
    "\3\37\1\62\14\37\1\41\6\37\1\40\1\0\1\42"+
    "\6\0\1\37\1\40\7\0\1\37\1\0\4\37\1\61"+
    "\13\37\1\41\6\37\1\40\1\0\1\42\6\0\1\37"+
    "\1\40\7\0\1\37\1\0\20\37\1\41\1\62\5\37"+
    "\1\40\1\0\1\42\6\0\1\37\1\40\7\0\1\37"+
    "\1\0\4\37\1\143\13\37\1\41\6\37\1\40\1\0"+
    "\1\42\6\0\1\37\1\40\7\0\1\37\1\0\11\37"+
    "\1\144\6\37\1\41\6\37\1\40\1\0\1\42\6\0"+
    "\1\37\1\40\7\0\1\37\1\0\6\37\1\114\11\37"+
    "\1\41\6\37\1\40\1\0\1\42\6\0\1\37\1\40"+
    "\7\0\1\37\1\0\11\37\1\145\6\37\1\41\6\37"+
    "\1\40\1\0\1\42\6\0\1\37\1\40\7\0\1\37"+
    "\1\0\20\37\1\41\1\37\1\146\4\37\1\40\1\0"+
    "\1\42\6\0\1\37\1\40\7\0\1\147\1\0\20\37"+
    "\1\41\6\37\1\40\1\0\1\42\6\0\1\37\1\40"+
    "\7\0\1\37\1\0\20\37\1\150\6\37\1\40\1\0"+
    "\1\42\6\0\1\37\1\40\7\0\1\37\1\0\20\37"+
    "\1\41\1\37\1\151\4\37\1\40\1\0\1\42\6\0"+
    "\2\41\7\0\1\41\1\0\1\152\1\41\1\152\1\41"+
    "\1\152\17\41\3\152\1\41\12\0\1\153\44\0\1\153"+
    "\4\0\1\132\40\0\1\132\10\0\1\133\10\0\1\133"+
    "\1\0\20\133\1\0\6\133\11\0\1\134\10\0\1\134"+
    "\1\0\20\134\1\0\6\134\12\0\1\135\40\0\1\135"+
    "\10\0\1\136\10\0\1\136\1\0\20\136\1\0\6\136"+
    "\11\0\1\136\1\46\1\154\6\0\1\136\1\0\20\136"+
    "\1\0\6\136\1\46\4\0\1\154\4\0\1\140\40\0"+
    "\1\140\1\0\1\140\6\0\1\37\1\40\7\0\1\37"+
    "\1\0\4\37\1\155\13\37\1\41\6\37\1\40\1\0"+
    "\1\42\6\0\1\37\1\40\7\0\1\37\1\0\5\37"+
    "\1\156\12\37\1\41\6\37\1\40\1\0\1\42\6\0"+
    "\1\37\1\40\7\0\1\37\1\0\1\37\1\61\16\37"+
    "\1\41\6\37\1\40\1\0\1\42\6\0\1\37\1\40"+
    "\7\0\1\37\1\0\6\37\1\62\11\37\1\41\6\37"+
    "\1\40\1\0\1\42\6\0\1\37\1\40\7\0\1\37"+
    "\1\0\17\37\1\157\1\41\6\37\1\40\1\0\1\42"+
    "\6\0\1\37\1\40\7\0\1\37\1\0\6\37\1\160"+
    "\11\37\1\41\6\37\1\40\1\0\1\42\6\0\1\37"+
    "\1\40\7\0\1\37\1\0\11\37\1\62\6\37\1\41"+
    "\6\37\1\40\1\0\1\42\6\0\2\41\7\0\1\41"+
    "\1\0\26\41\1\161\1\41\10\0\1\37\1\40\7\0"+
    "\1\37\1\0\6\37\1\162\11\37\1\41\6\37\1\40"+
    "\1\0\1\42\7\0\1\153\40\0\1\153\11\0\1\163"+
    "\40\0\1\163\1\0\1\164\6\0\1\37\1\40\7\0"+
    "\1\37\1\0\2\37\1\165\15\37\1\41\6\37\1\40"+
    "\1\0\1\42\6\0\1\37\1\40\7\0\1\37\1\0"+
    "\7\37\1\166\10\37\1\41\6\37\1\40\1\0\1\42"+
    "\6\0\1\37\1\40\7\0\1\37\1\0\20\37\1\167"+
    "\6\37\1\40\1\0\1\42\6\0\1\37\1\40\7\0"+
    "\1\37\1\0\11\37\1\170\6\37\1\41\6\37\1\40"+
    "\1\0\1\42\6\0\2\41\7\0\1\41\1\0\1\41"+
    "\1\152\25\41\1\152\10\0\1\37\1\40\7\0\1\37"+
    "\1\0\11\37\1\171\6\37\1\41\6\37\1\40\1\0"+
    "\1\42\7\0\1\172\40\0\1\172\10\0\1\37\1\40"+
    "\7\0\1\37\1\0\5\37\1\173\12\37\1\41\6\37"+
    "\1\40\1\0\1\42\6\0\1\37\1\40\7\0\1\37"+
    "\1\0\20\37\1\174\6\37\1\40\1\0\1\42\6\0"+
    "\2\41\7\0\1\41\1\0\2\41\1\175\25\41\10\0"+
    "\1\37\1\40\7\0\1\37\1\0\17\37\1\62\1\41"+
    "\6\37\1\40\1\0\1\42\6\0\1\37\1\40\7\0"+
    "\1\37\1\0\17\37\1\176\1\41\6\37\1\40\1\0"+
    "\1\42\7\0\1\172\40\0\1\172\1\0\1\177\6\0"+
    "\1\37\1\40\7\0\1\37\1\0\6\37\1\200\11\37"+
    "\1\41\6\37\1\40\1\0\1\42\6\0\2\41\7\0"+
    "\1\41\1\0\4\41\1\152\1\41\1\201\6\41\1\202"+
    "\12\41\10\0\2\41\7\0\1\152\1\0\30\41\10\0"+
    "\1\37\1\40\7\0\1\37\1\0\3\37\1\203\14\37"+
    "\1\41\6\37\1\40\1\0\1\42\7\0\1\204\40\0"+
    "\1\204\10\0\1\37\1\40\7\0\1\37\1\0\7\37"+
    "\1\205\10\37\1\41\6\37\1\40\1\0\1\42\6\0"+
    "\2\41\7\0\1\41\1\0\1\41\1\206\26\41\10\0"+
    "\2\41\7\0\1\41\1\0\10\41\1\207\17\41\10\0"+
    "\1\37\1\40\7\0\1\37\1\0\16\37\1\62\1\37"+
    "\1\41\6\37\1\40\1\0\1\42\7\0\1\204\14\0"+
    "\1\210\23\0\1\204\10\0\1\37\1\40\7\0\1\37"+
    "\1\0\10\37\1\211\7\37\1\41\6\37\1\40\1\0"+
    "\1\42\6\0\2\41\7\0\1\41\1\0\14\41\1\152"+
    "\13\41\10\0\2\41\7\0\1\41\1\0\21\41\1\212"+
    "\6\41\12\0\1\213\44\0\1\213\3\0\1\37\1\40"+
    "\7\0\1\37\1\0\6\37\1\214\11\37\1\41\6\37"+
    "\1\40\1\0\1\42\6\0\2\41\7\0\1\41\1\0"+
    "\15\41\1\152\12\41\11\0\1\213\40\0\1\213\1\0"+
    "\1\164\6\0\1\37\1\40\7\0\1\37\1\0\10\37"+
    "\1\215\7\37\1\41\6\37\1\40\1\0\1\42\6\0"+
    "\1\37\1\40\7\0\1\37\1\0\4\37\1\216\13\37"+
    "\1\41\6\37\1\40\1\0\1\42\6\0\1\37\1\40"+
    "\7\0\1\37\1\0\3\37\1\217\14\37\1\41\6\37"+
    "\1\40\1\0\1\42\6\0\1\37\1\40\7\0\1\37"+
    "\1\0\11\37\1\220\6\37\1\41\6\37\1\40\1\0"+
    "\1\42\5\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5461];
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
    "\1\1\1\11\7\1\1\11\15\1\1\11\1\1\1\11"+
    "\7\1\1\0\1\1\1\0\2\1\1\11\2\1\1\11"+
    "\22\1\1\0\2\11\2\0\26\1\1\0\23\1\1\0"+
    "\22\1\1\0\4\1\1\0\3\1\1\0\2\1\1\0"+
    "\5\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[144];
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
        case 2: 
          { lexeme=yytext(); line=yyline; return ERRORL_000;
          }
        case 24: break;
        case 23: 
          { lexeme=yytext(); line=yyline; return ERRORL_003;
          }
        case 25: break;
        case 22: 
          { lexeme=yytext(); line=yyline; return ERRORL_006;
          }
        case 26: break;
        case 19: 
          { lexeme=yytext(); line=yyline; return ERRORL_009;
          }
        case 27: break;
        case 6: 
          { lexeme=yytext(); line=yyline; return TK_Sig_Punt;
          }
        case 28: break;
        case 13: 
          { lexeme=yytext(); line=yyline; return TK_Op_Disminucion;
          }
        case 29: break;
        case 7: 
          { lexeme=yytext(); line=yyline; return TK_Sig_Agrup;
          }
        case 30: break;
        case 9: 
          { lexeme=yytext(); line=yyline; return TK_Op_Asig;
          }
        case 31: break;
        case 11: 
          { lexeme=yytext(); line=yyline; return ERRORL_001;
          }
        case 32: break;
        case 1: 
          { lexeme=yytext(); line=yyline; return ERRORL_004;
          }
        case 33: break;
        case 21: 
          { lexeme=yytext(); line=yyline; return ERRORL_007;
          }
        case 34: break;
        case 17: 
          { lexeme=yytext(); line=yyline; return TK_Op_Incremento;
          }
        case 35: break;
        case 5: 
          { /*Ignorar*/
          }
        case 36: break;
        case 8: 
          { lexeme=yytext(); line=yyline; return TK_Op_Relacional;
          }
        case 37: break;
        case 18: 
          { lexeme=yytext(); line=yyline; return ERRORL_010;
          }
        case 38: break;
        case 15: 
          { lexeme=yytext(); line=yyline; return TK_Op_Desigual;
          }
        case 39: break;
        case 4: 
          { lexeme=yytext(); line=yyline; return TK_Op_Arit;
          }
        case 40: break;
        case 14: 
          { lexeme=yytext(); line=yyline; return ERRORL_002;
          }
        case 41: break;
        case 20: 
          { lexeme=yytext(); line=yyline; return ERRORL_005;
          }
        case 42: break;
        case 12: 
          { lexeme=yytext(); line=yyline; return ERRORL_008;
          }
        case 43: break;
        case 10: 
          { lexeme=yytext(); line=yyline; return IDENTIFICADOR;
          }
        case 44: break;
        case 3: 
          { lexeme=yytext(); line=yyline; return Num;
          }
        case 45: break;
        case 16: 
          { lexeme=yytext(); line=yyline; return Reservada;
          }
        case 46: break;
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