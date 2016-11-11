import React, { Component, PropTypes } from 'react';

import 
{
	 AppRegistry,
	 Text,
	 TextInput,
	 StyleSheet,
	 TouchableOpacity,
	 Navigator,
	 ListView,
	 View
} 
from 'react-native';

const styles = StyleSheet.create({
	
	 container: {
		flex: 1,
		justifyContent: 'center',
		alignItems: 'center',
		backgroundColor: '#F5FCFF',
	 },

	 simpleText: {
		 fontSize: 20,
		 textAlign: 'left',
	 },

	 buttonText: {
		 fontSize: 20,
		 textAlign: 'center',
	 },
	 
	 welcome: {
		fontSize: 20,
		textAlign: 'center',
		margin: 10,
	 },
	 
	 welcomeBlue: {
		 fontSize: 20,
		textAlign: 'center',
		margin: 10,
		color: '#80A4B3',
	 },
	 
	 instructions: {
		textAlign: 'center',
		color: '#333333',
		marginBottom: 5,
	 },
	 
});

export class FirstPage extends Component
{
	static get defaultProps()
	{
		return {
			title: 'My scene'
		};
	}

	render()
	{
		return (
			<View>
				<Text style= {styles.welcomeBlue}> 
					{this.props.title}
				</Text>
				<TouchableOpacity onPress = {this.props.onForward}>
					<Text style = {styles.simpleText}> Submit form </Text>
				</TouchableOpacity>
				<TouchableOpacity onPress = {this.props.onBack}>
					<Text style = {styles.simpleText}> Locations </Text>
				</TouchableOpacity>
			</View>
		)
	}
}

FirstPage.proptype = {
		title: PropTypes.string.isRequired,
		onForward: PropTypes.func.isRequired,
		onBack: PropTypes.func.isRequired,
};