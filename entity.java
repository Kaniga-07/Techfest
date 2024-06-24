import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GroupInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int groupId;
    private int members;
    private String gender;

    // Getters and Setters
}

@Entity
public class HostelInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hostelName;
    private int roomNumber;
    private int capacity;
    private String gender;

    // Getters and Setters
}
