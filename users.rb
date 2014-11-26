class UserNode

    attr_accessor :user, :pass, :next_node

    def initialize (user,pass,next_node)
        @user = user
		@pass = pass
        @next_node = next_node
    end
end

class Users

    def initialize ()
        @head = nil #UserNode.new(user,pass,nil)
		loadUsers
    end

	def loadUsers()
		File.open("users.txt","r") do |f|
			while line = f.gets
				linea = line.split(",")
				user = linea[0]
				pass =  line[1]
				add(user,pass)			
			end		
		end
	end
    
    def add(user,pass)
        current = @head
		if @head == nil
			@head = UserNode.new(user,pass,nil)
		else
		    while current.next_node != nil
		        current = current.next_node
		    end 
		    current.next_node = UserNode.new(user,pass,nil)
		    self    
    	end
	end

	def validateUser(data)
		user = data.split(",")
		pass = data.split(" ")
		current = @head
		while current.next_node != nil
			if(current.user == user)
				if(current.pass == pass)
					return 1
				else
					return 0
				end
			else
				current = current.next_node
			end
		end
		return 2
	end


	def display
        current = @head
        while current.next_node != nil 
			puts "Usuario: " << current.user.to_s << "\nPassword: " << current.pass.to_s
            current = current.next_node
        end
		puts "Usuario: " << current.user.to_s << "\nPassword: " << current.pass.to_s
    end

end
