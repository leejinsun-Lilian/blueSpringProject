package com.boss.blueSpring.challenge.model.vo;

public class ChallengeMemberInfo {
	private int memberNo;
	private int challengeNo;
	
	public ChallengeMemberInfo() {
	}

	public ChallengeMemberInfo(int memberNo, int challengeNo) {
		super();
		this.memberNo = memberNo;
		this.challengeNo = challengeNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getChallengeNo() {
		return challengeNo;
	}

	public void setChallengeNo(int challengeNo) {
		this.challengeNo = challengeNo;
	}

	@Override
	public String toString() {
		return "Like [memberNo=" + memberNo + ", challengeNo=" + challengeNo + "]";
	}

	
	
}
