public void allocateRooms() {
    List<GroupInfo> groups = getAllGroups();
    List<HostelInfo> hostels = getAllHostels();

    // Allocation logic here
    for (GroupInfo group : groups) {
        for (HostelInfo hostel : hostels) {
            if (group.getGender().equalsIgnoreCase(hostel.getGender()) && group.getMembers() <= hostel.getCapacity()) {
                // Assign group to hostel room
                hostel.setCapacity(hostel.getCapacity() - group.getMembers());
                // Save the updated hostel information back to the repository
                hostelInfoRepository.save(hostel);
                break;
            }
        }
    }
}
