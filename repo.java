import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupInfoRepository extends JpaRepository<GroupInfo, Long> {
}

public interface HostelInfoRepository extends JpaRepository<HostelInfo, Long> {
}
