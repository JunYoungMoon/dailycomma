package com.yedam.dailycomma.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.dailycomma.host.HostDAO;
import com.yedam.dailycomma.host.HostDTO;
import com.yedam.dailycomma.host.HostSearchDTO;
import com.yedam.dailycomma.lodgment.LodgmentDAO;
import com.yedam.dailycomma.lodgment.LodgmentDTO;
import com.yedam.dailycomma.lodgment.LodgmentSearchDTO;
import com.yedam.dailycomma.member.MemberDAOMybatis;
import com.yedam.dailycomma.member.MemberDTO;
import com.yedam.dailycomma.member.MemberSearchDTO;
import com.yedam.dailycomma.reservation.ReservationDAOMybatis;
import com.yedam.dailycomma.reservation.ReservationDTO;
import com.yedam.dailycomma.reservation.ReservationSearchDTO;
import com.yedam.dailycomma.room.RoomDAOMybatis;
import com.yedam.dailycomma.room.RoomDTO;
import com.yedam.dailycomma.room.RoomSearchDTO;
import com.yedam.dailycomma.tour.TourDAO;
import com.yedam.dailycomma.tour.TourDTO;
import com.yedam.dailycomma.tour.TourSearchDTO;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired MemberDAOMybatis memberDAO;
	@Autowired HostDAO hostDAO;
	@Autowired LodgmentDAO lodgmentDAO;
	@Autowired RoomDAOMybatis roomDAO;
	@Autowired ReservationDAOMybatis reservationDAO;
	@Autowired TourDAO tourDAO;
	@Autowired AdminDAO adminDAO;
	
	
	//회원
	public List<MemberDTO> getMembers(MemberSearchDTO memberSearchDTO) {
		return memberDAO.getMembers(memberSearchDTO);
	}
	public int getMemberCnt(MemberSearchDTO memberSearchDTO) {
		return memberDAO.getCnt(memberSearchDTO);
	}
	public int deleteMember(MemberDTO dto) {
		return memberDAO.deleteMember(dto);
	}
	
	//업주
	public List<HostDTO> getHosts(HostSearchDTO hostSearchDTO) {
		return hostDAO.getHosts(hostSearchDTO);
	}
	public int getHostCnt(HostSearchDTO hostSearchDTO) {
		return hostDAO.getCnt(hostSearchDTO);
	}
	public int deleteHost(HostDTO dto) {
		return hostDAO.deleteHost(dto);
	}
	
	//업체(숙소)
	public List<LodgmentDTO> getLodgments(LodgmentSearchDTO lodgmentSearchDTO) {
		return lodgmentDAO.getLodgments(lodgmentSearchDTO);
	}
	public int getLodgmentCnt(LodgmentSearchDTO lodgmentSearchDTO) {
		return lodgmentDAO.getCnt(lodgmentSearchDTO);
	}
	public int deleteLodgment(LodgmentDTO dto) {
		return lodgmentDAO.deleteLodgment(dto);
	}

	//객실
	public List<RoomDTO> getRooms(RoomSearchDTO roomSearchDTO) {
		return roomDAO.getRooms(roomSearchDTO);
	}
	public int getRoomCnt(String lodgmentNo) {
		return roomDAO.getTotal(lodgmentNo);
	}
	public List<RoomDTO> getEachRooms(RoomSearchDTO roomSearchDTO) {
		return roomDAO.getEachRooms(roomSearchDTO);
	}
	public int deleteRoom(RoomDTO dto) {
		return roomDAO.deleteRoom(dto);
	}

	//예약
	public List<ReservationDTO> getReservations(ReservationSearchDTO reservationSearchDTO) {
		return reservationDAO.getReservations(reservationSearchDTO);
	}
	public int getReservationCnt(ReservationSearchDTO reservationSearchDTO) {
		return reservationDAO.getCnt(reservationSearchDTO);
	}
	public int deleteReservation(ReservationDTO dto) {
		return reservationDAO.deleteReservation(dto);
	}
	
	//캐스트(투어)
	public List<TourDTO> getTours(TourSearchDTO tourSearchDTO) {
		return tourDAO.getTours(tourSearchDTO);
	}
	public int getTourCnt(TourSearchDTO tourSearchDTO) {
		return tourDAO.getCnt(tourSearchDTO);
	}
	public int deleteTour(TourDTO dto) {
		return tourDAO.deleteTour(dto);
	}
	
	@Override
	public int deleteMembers(List<String> checkbox) {
		// TODO Auto-generated method stub
		return adminDAO.deleteMembers(checkbox);
	}
	
	@Override
	public int deleteLodgments(List<String> checkbox) {
		// TODO Auto-generated method stub
		return adminDAO.deleteLodgments(checkbox);
	}
	@Override
	public int deleteReserves(List<String> checkbox) {
		// TODO Auto-generated method stub
		return adminDAO.deleteReserves(checkbox);
	}
	@Override
	public int deleteTours(List<String> checkbox) {
		// TODO Auto-generated method stub
		return adminDAO.deleteTours(checkbox);
	}
	@Override
	public int deleteRooms(List<String> checkbox) {
		// TODO Auto-generated method stub
		return adminDAO.deleteRooms(checkbox);
	}
	@Override
	public int approveHost(HostSearchDTO dto) {
		// TODO Auto-generated method stub
		return hostDAO.approveHost(dto);
	}
	@Override
	public int unapproveHost(HostSearchDTO dto) {
		// TODO Auto-generated method stub
		return hostDAO.unapproveHost(dto);
	}
	@Override
	public int approveTour(TourSearchDTO dto) {
		// TODO Auto-generated method stub
		return tourDAO.approveTour(dto);
	}
	@Override
	public int unapproveTour(TourSearchDTO dto) {
		// TODO Auto-generated method stub
		return tourDAO.unapproveTour(dto);
	}
	@Override
	public int memberWithdraw(MemberDTO dto) {
		// TODO Auto-generated method stub
		return memberDAO.updateMember(dto);
	}
}
