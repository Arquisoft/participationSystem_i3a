package es.uniovi.asw;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.dao.ProposalDao;
import es.uniovi.asw.dao.UserDao;
import es.uniovi.asw.dao.VoteDao;
import es.uniovi.asw.kafka.KafkaProducer;
import es.uniovi.asw.model.Proposal;
import es.uniovi.asw.model.User;
@Controller
public class MainController {

    @Autowired
    private KafkaProducer kafkaProducer;
    
    @RequestMapping("/")
    public ModelAndView landing(Model model) {
    	//model.addAttribute("message", new Message());
    	ModelAndView model2 = new ModelAndView("login");
    	model.addAttribute("uID", new Integer(0));
    	model.addAttribute("uPASS", "");
    	model.addAttribute("errorMsg", "");
        return model2;
    }
    
    @RequestMapping("/send")
    public String send(Model model, @ModelAttribute Message message) {
        kafkaProducer.send("exampleTopic", message.getMessage());
        return "redirect:/";
    }
	
    @RequestMapping("/showAddProposals")
    public String showAddProposals(@ModelAttribute("uID") Integer uId, @ModelAttribute("uPASS") String uPass, 
    									Model model, HttpServletRequest request,	HttpServletResponse response) {
    	User user = UserDao.getUserLog(uId, uPass);
    	
		if (user == null)
			return ("login");
		else {
			// see getAllProposals(). We get the proposals from html.
			//((ModelAndView) model).addObject("proposals", getAllProposals());
			return "showAddProposals";
		}
    }
    
    @RequestMapping("/commentProposal/{id}")
    //move to commentProposal.html
    public String commentProposal(@PathVariable("id") Integer id){
    	//TODO
    	return "";
    }
    
    @RequestMapping("/upvoteProposal/{id}")
    public String upvoteProposal(@PathVariable("id") Integer id, @ModelAttribute("uID") Integer uid){
    	new VoteDao();
    	VoteDao.InsertVotesProp(id, uid, new Integer(1));
    	return "showAddProposals";
    }
    
    @RequestMapping("/downvoteProposal/{id}")
    public String downvoteProposal(@PathVariable("id") Integer id, @ModelAttribute("uID") Integer uid){
    	new VoteDao();
    	VoteDao.InsertVotesProp(id, uid, new Integer(1));
    	return "showAddProposals";
    }
    
    @RequestMapping("/createProposal")
    public String createProposal(){
    	//TODO
    	return "";
    }
    
    @RequestMapping("/createComment/{id}")
    // {id} proposal ID
    public String createComment(@PathVariable("id") Integer id){
    	//TODO
    	return "";
    }
    
    @RequestMapping("/upvoteComment/{id}")
    public String upvoteComment(@PathVariable("id") Integer id, @ModelAttribute("uID") Integer uid){
    	new VoteDao();
    	VoteDao.InsertVotesCom(id, uid, new Integer(1));
    	return "showAddProposals";
    }
    
    @RequestMapping("/downvoteComment/{id}")
    public String downvoteComment(@PathVariable("id") Integer id, @ModelAttribute("uID") Integer uid){
    	new VoteDao();
    	VoteDao.InsertVotesCom(id, uid, new Integer(1));
    	return "showAddProposals";
    }
    
    /*
     * ejecutarlo en los html, con bucle 
     * <tr th:each="p : ${allProposals}">
     * p.getTitle()...
     */
    @ModelAttribute("allProposals")
    public List<Proposal> getAllProposals(){
    	new ProposalDao();
    	return ProposalDao.getAllProposals();
    }
    
}