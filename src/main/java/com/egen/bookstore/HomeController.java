package com.egen.bookstore;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egen.bookstore.model.Book;
import com.egen.bookstore.model.User;
import com.egen.bookstore.model.ValidationError;
import com.egen.bookstore.service.BookService;
import com.egen.bookstore.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Handles requests for the application home page.
 */
/**
 * @author harsh
 *
 */
@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	/** Creates a user
	 * @param user Accepts JSON
	 * @return returns JSON of User
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody String createUser(@RequestBody User user) {
		Gson gson = new Gson();
		ValidationError v = userService.validateUser(user);
		if (!v.getErrors().isEmpty())
			return gson.toJson(v);
		userService.createUser(user);
		return gson.toJson(user);
	}

	/** Returns JSON containing all users
	 * 	
	 */
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public @ResponseBody String getAllUsers(Locale locale, Model model) {
		Gson gson = new Gson();
		List<User> userList = userService.getAllUsers();
		if (userList == null || userList.size() == 0)
			return "No Users found";
		String jsonUserList = gson.toJson(userList);
		System.out.println("users: " + jsonUserList);

		return jsonUserList;
	}

	/** Returns JSON containing updated users
	 * 	
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody User updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return user;
	}

	/** Returns JSON containing all books from inventory
	 * 	
	 */
	@RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
	public @ResponseBody String getAllBooks(Locale locale, Model model) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		
		List<Book> bookList = bookService.getAllBooks();
		if (bookList == null || bookList.size() == 0)
			return "No Book(s) found";
		String jsonBookList = gson.toJson(bookList);
		System.out.println("books: " + jsonBookList);

		return jsonBookList;
	}

	/** 
	 * @param name
	 * @return Returns JSON of book with given name
	 */
	@RequestMapping(value = "/findBookByName/{name}", method = RequestMethod.GET)
	public @ResponseBody String findBookByName(@PathVariable String name, Locale locale, Model model) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		List<Book> books = bookService.findBookByName(name);
		if (books == null || books.size() == 0) {
			return "book not found";
		}
		return gson.toJson(books.get(0));
	}

	/**
	 * @param book Accepts JSON of book
	 * @return Returns JSON of created book
	 */
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public @ResponseBody Book addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return book;
	}

	/**
	 * @param userId Accepts Id of user from URL
	 * @param bookId Accepts Id of book from URL
	 * @return Returns a message or a JSON of book
	 */
	@RequestMapping(value = "/checkOutBook/{userId}/{bookId}", method = RequestMethod.GET)
	public @ResponseBody String checkOutBook(@PathVariable Long userId, @PathVariable Long bookId, Locale locale,
			Model model) {
		Gson g = new Gson();
		Object o = bookService.checkOutBook(userId, bookId);
		if(o instanceof String) return (String) o;
		return g.toJson((Book)o);
	}
}
