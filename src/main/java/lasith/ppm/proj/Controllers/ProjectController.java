package lasith.ppm.proj.Controllers;

import lasith.ppm.proj.Services.ProjectService;
import lasith.ppm.proj.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<?> createORUpdateProject(@Valid @RequestBody Project project, BindingResult result){

        if(result.hasErrors()){
            return new ResponseEntity<String>("Invalid project body", HttpStatus.BAD_REQUEST);
        }

        Project newProject = projectService.saveOrUpdate(project);
        return new ResponseEntity<Project>(newProject, HttpStatus.CREATED);
    }


}
