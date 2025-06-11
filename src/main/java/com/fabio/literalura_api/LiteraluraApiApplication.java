package com.fabio.literalura_api;

import com.fabio.literalura_api.model.Author;
import com.fabio.literalura_api.model.Book;
import com.fabio.literalura_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApiApplication implements CommandLineRunner {


	@Autowired
	private BookService bookService;

	@Override
	public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            buildMenu();
            option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
				case 1:
					System.out.println("Enter title: ");
					String title = scanner.nextLine();

					Book book = bookService.getBookByTitle(title);

					if (book == null) {
						System.out.println("Book not found");
						break;
					}

					System.out.println(book);
					break;
				case 2:
					break;
				case 3:
					System.out.println("Enter the author: ");
					String author = scanner.nextLine();

//					Author author = Book.getAuthor(); // TODO: logic for getting the authors
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					System.out.println("Invalid option");
					break;
			}
        } while (option != 0);
    }

	private void buildMenu() {
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println("Escolha o numero da sua opcao: ");
		System.out.println("1. Buscar livro pelo titulo");
		System.out.println("2. Listar livros registrados");
		System.out.println("3. Listar autoreas redistrados");
		System.out.println("4. Listar autoreas vivos em um determinado ano");
		System.out.println("5. Listar livros em um determinado idioma");
		System.out.println("0. Sair");
		System.out.print("-> ");
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApiApplication.class, args);
	}

}
