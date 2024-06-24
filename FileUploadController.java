import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FileUploadController {

    @Autowired
    private AllocationService allocationService;

    @PostMapping("/uploadGroups")
    public String uploadGroups(@RequestParam("file") MultipartFile file) {
        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Group ID", "Members", "Gender"));
            List<GroupInfo> groups = new ArrayList<>();
            for (CSVRecord record : csvParser) {
                GroupInfo group = new GroupInfo();
                group.setGroupId(Integer.parseInt(record.get("Group ID")));
                group.setMembers(Integer.parseInt(record.get("Members")));
                group.setGender(record.get("Gender"));
                groups.add(group);
            }
            allocationService.saveGroups(groups);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error uploading file";
        }
        return "File uploaded successfully";
    }

    @PostMapping("/uploadHostels")
    public String uploadHostels(@RequestParam("file") MultipartFile file) {
        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Hostel Name", "Room Number", "Capacity", "Gender"));
            List<HostelInfo> hostels = new ArrayList<>();
            for (CSVRecord record : csvParser) {
                HostelInfo hostel = new HostelInfo();
                hostel.setHostelName(record.get("Hostel Name"));
                hostel.setRoomNumber(Integer.parseInt(record.get("Room Number")));
                hostel.setCapacity(Integer.parseInt(record.get("Capacity")));
                hostel.setGender(record.get("Gender"));
                hostels.add(hostel);
            }
            allocationService.saveHostels(hostels);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error uploading file";
        }
        return "File uploaded successfully";
    }

    @GetMapping("/allocate")
    public String allocateRooms() {
        // Implement allocation logic here
        return "Rooms allocated successfully";
    }
}
