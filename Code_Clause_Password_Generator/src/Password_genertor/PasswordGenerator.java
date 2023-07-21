package Password_genertor;
import java.util.Random;

public final class PasswordGenerator {

  
    private static final int charactersSize = 1000;
    private static char [] characters = new char [charactersSize];

    private static int charactersCount = 0;

    private int passwordSize;

    public PasswordGenerator( int passwordSize ) {

      this.passwordSize = passwordSize;

      initCharacters();
    }


    private static char [] initCharacters() {
      int i = 0;

      for ( int j = 48; j < 58; ++i, ++j, ++charactersCount ) {
        characters[i] = (char) j;
      }

      for ( int j = 64; j < 91; ++i, ++j, ++charactersCount ) {
        characters[i] = (char) j;
      }

      for ( int j = 97; j < 123; ++i, ++j, ++charactersCount ) {
        characters[i] = (char) j;
      }

      return characters;
    }

    public char [] get() {

      Random rnd = new Random();

      char [] password = new char [passwordSize];


      for ( int i = 0; i < passwordSize; ++i ) {
        password[i] = characters[ rnd.nextInt(charactersCount) ];
      }

      return password;
    }


    public void showCharacters() {
      for ( int i = 0; i < charactersCount && characters[i] != 0; ++i ) {
        System.out.println(characters[i]);
      }
    }

    public static void main(String[] args) {
      int passwordSize = 8;
      PasswordGenerator password = new PasswordGenerator( passwordSize );
      System.out.println("Your Password is Generated: ");
      System.out.println( password.get() );   
    }

}