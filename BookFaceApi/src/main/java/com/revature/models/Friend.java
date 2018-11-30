package com.revature.models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="friends")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="friendId")
@DiscriminatorValue(value="true")
public class Friend{
	
	@EmbeddedId
	private FriendId friendId;

	public Friend(FriendId friendId) {
		super();
		this.friendId = friendId;
	}

	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FriendId getFriendId() {
		return friendId;
	}

	public void setFriendId(FriendId friendId) {
		this.friendId = friendId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friendId == null) ? 0 : friendId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Friend other = (Friend) obj;
		if (friendId == null) {
			if (other.friendId != null)
				return false;
		} else if (!friendId.equals(other.friendId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Friend [friendId=" + friendId + "]";
	}
	
	
}

