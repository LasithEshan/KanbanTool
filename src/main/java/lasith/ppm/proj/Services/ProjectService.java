package lasith.ppm.proj.Services;

import lasith.ppm.proj.domain.Project;
import lasith.ppm.proj.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){
        return projectRepository.save(project);
    }
}
