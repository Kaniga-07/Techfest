import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationService {

    @Autowired
    private GroupInfoRepository groupInfoRepository;

    @Autowired
    private HostelInfoRepository hostelInfoRepository;

    public List<GroupInfo> getAllGroups() {
        return groupInfoRepository.findAll();
    }

    public List<HostelInfo> getAllHostels() {
        return hostelInfoRepository.findAll();
    }

    public void saveGroups(List<GroupInfo> groups) {
        groupInfoRepository.saveAll(groups);
    }

    public void saveHostels(List<HostelInfo> hostels) {
        hostelInfoRepository.saveAll(hostels);
    }

    // Allocation logic to be implemented here
}
