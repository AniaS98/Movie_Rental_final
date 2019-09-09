
package movierental_netbeans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

enum Genres {/*pominęłam obyczajowy*/
    Drama, Comedy, Horror, Biographical, Psychological, War, Gangster, Thriller
}
public class Main {

    public static void main(String[] args) throws IOException {
        Client p = new Client("Kasia", "Otko", "3265416", "sdcsd@wp.pl", "login", "password");
        System.out.println(p);
        
        Movie[] tab = new Movie[16];
        
        Movie f1 = tab[0] = new Movie("Skazani na Shawshank", "Adaptacja opowiadania Stephena Kinga. Niesłusznie skazany na dożywocie bankier, stara się przetrwać w brutalnym, więziennym świecie.", "Frank Darabont", "1994", Genres.Drama);
        Movie f2 = tab[1] = new Movie("Nietykalni", "Sparaliżowany milioner zatrudnia do opieki młodego chłopaka z przedmieścia, który właśnie wyszedł z więzienia.", "Olivier Nakache, Eric Toledano", "2011", Genres.Biographical);
        Movie f3 = tab[3] = new Movie("Zielona mila", "Emerytowany strażnik więzienny opowiada przyjaciółce o niezwykłym mężczyźnie, którego skazano na śmierć za zabójstwo dwóch 9-letnich dziewczynek.", "Frank Darabont", "1999", Genres.Drama);
        Movie f4 = tab[4] = new Movie("Ojciec chrzestny", "Opowieść o nowojorskiej rodzinie mafijnej. Starzejący się Don Corleone pragnie przekazać władzę swojemu synowi.", "Francis Ford Coppola", "1972", Genres.Drama);
        Movie f5 = tab[5] = new Movie("Dwunastu gniewnych ludzi", "Dwunastu przysięgłych ma wydać wyrok w procesie o morderstwo. Jeden z nich ma wątpliwości dotyczące winy oskarżonego.", "Sidney Lumet", "1957", Genres.Drama);
        Movie f6 = tab[6] = new Movie("Forrest Gump", "Historia życia Forresta, chłopca o niskim ilorazie inteligencji z niedowładem kończyn, który staje się miliarderem i bohaterem wojny w Wietnamie.", "Robert Zemeckis", "1994", Genres.Drama);
        Movie f7 = tab[7] = new Movie("Lot nad kukułczym gniazdem ", "Historia złodzieja, szulera i chuligana, który, by uniknąć więzienia, udaje niepoczytalność. Trafia do szpitala dla umysłowo chorych, gdzie twardą ręką rządzi siostra Ratched.", "Milos Forman", "1975", Genres.Psychological);
        Movie f8 = tab[8] = new Movie("Lista Schindlera", "Historia przedsiębiorcy Oskara Schindlera, który podczas II wojny światowej uratował przed pobytem w obozach koncentracyjnych 1100 Żydów.", "Steven Spielberg", "1993", Genres.War);
        Movie f9 = tab[9] = new Movie("Pulp Fiction", "Przemoc i odkupienie w opowieści o dwóch płatnych mordercach pracujących na zlecenie mafii, żonie gangstera, bokserze i parze okradającej ludzi w restauracji.", "Quentin Tarantino", "1994", Genres.Gangster);
        Movie f10 = tab[10] = new Movie("Życie jest piękne", "Zamknięty w obozie koncentracyjnym wraz z synem Guido próbuje przekonać chłopca, że okrutna rzeczywistość jest jedynie formą zabawy dla dorosłych.", "Roberto Beningi", "1997", Genres.Drama);
        Movie f11 = tab[11] = new Movie("Siedem", "Dwóch policjantów stara się złapać seryjnego mordercę wybierającego swoje ofiary wg specjalnego \"klucza\".", "Dawid Fincher", "1995", Genres.Thriller);
        Movie f12 = tab[12] = new Movie("Podziemy krąg", "Dwóch mężczyzn znudzonych rutyną zakłada klub, w którym co tydzień odbywają się walki na gołe pięści.", "David Fincher", "1999", Genres.Thriller);
        Movie f13 = tab[13] = new Movie("Chłopcy z ferajny", "Kilkunastoletni Henry i Tommy DeVito trafiają pod opiekę potężnego gangstera. Obaj szybko uczą się panujących w mafii reguł.", "Martin Scorsese", "1990", Genres.Gangster);
        Movie f14 = tab[14] = new Movie("Pianista", "Podczas drugiej wojny światowej Władysław Szpilman, znakomity polski pianista, stara się przeżyć w okupowanej Warszawie. ", "Roman Polański", "2002", Genres.Biographical);
        Movie f15 = tab[15] = new Movie("Incepcja", "Czasy, gdy technologia pozwala na wchodzenie w świat snów. Złodziej Cobb ma za zadanie wszczepić myśl do śpiącego umysłu.", "Christopher Nolan", "2010", Genres.Thriller);

        System.out.println(f1);

        AvailableMoviesList list = new AvailableMoviesList("MovieList");
        
        System.out.println("Dodanie filmu");
        
        list.AddMovie(f1);
        list.AddMovie(f2);
        list.AddMovie(f3);
        list.AddMovie(f4);
        list.AddMovie(f5);
        list.AddMovie(f6);
        list.AddMovie(f7);
        list.AddMovie(f8);
        list.AddMovie(f9);
        list.AddMovie(f10);
        list.AddMovie(f11);
        list.AddMovie(f12);
        list.AddMovie(f13);
        list.AddMovie(f14);
        list.AddMovie(f15);
        
        
        System.out.println("Dodanie filmów do listy");
        
        System.out.println("Wyświetlenie listy");
        
        System.out.println(list.toString());
        
        list.SaveXML("AvailableMoviesList.xml", list);
            System.out.println("poszło");
            
            
        AccountSystem system = new AccountSystem();
        system.AddAccount(p);
        AccountSystem.SaveXML("System.xml", system);
        AccountSystem systemOdczytany = (AccountSystem)AccountSystem.ReadXML("System.xml");
        Client client = systemOdczytany.CheckLoginPassword("login", "password");
        System.out.println(client.toString());
    }
}