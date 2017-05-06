package es.uniovi.asw;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.dao.ProposalDao;
import es.uniovi.asw.dao.UserDao;
import es.uniovi.asw.model.Proposal;
import es.uniovi.asw.model.User;
import es.uniovi.asw.producers.KafkaProducer;

@Controller
public class MainController {

    @Autowired
    private KafkaProducer kafkaProducer;
    

    @RequestMapping("/")
    public String landing(Model model) {
       // model.addAttribute("message", new Message());
    	model.addAttribute("uID", 0);
    	model.addAttribute("uPASS", "");
    	model.addAttribute("errorMsg", "");
        return "login";
    }
    
    @RequestMapping("/send")
    public String send(Model model, @ModelAttribute Message message) {
        kafkaProducer.send("exampleTopic", message.getMessage());
        return "redirect:/";
    }
	
    @RequestMapping("/showAddProposals")
    public ModelAndView showAddProposals(@ModelAttribute("uID") int uId, @ModelAttribute("uPASS") String uPass, 
    									HttpServletRequest request,	HttpServletResponse response) {
    	User user = UserDao.getUserLog(uId, uPass);

    	ModelAndView model;
    	
		if (user == null)
			model = new ModelAndView("login");
		else {
			model = new ModelAndView("showAddProposals");
			model.addObject(getAllProposals());
		}
		return model;
    }
    
    @ModelAttribute("allProposals")
    public List<Proposal> getAllProposals(){
    	new ProposalDao();
    	return ProposalDao.getAllProposals();
    }
    
}